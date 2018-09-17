package org.verscend.bbplus.resource;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.BloodGroup;
import org.verscend.bbplus.models.District;
import org.verscend.bbplus.models.User;
import org.verscend.bbplus.repository.BloodGroupRepository;
import org.verscend.bbplus.repository.DistrictRepository;
import org.verscend.bbplus.repository.UserRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserResource {

	@Autowired
	UserRepository userRepository;

	@Autowired
	BloodGroupRepository bloodGroupRepository;

	@Autowired
	DistrictRepository districtRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@PostMapping("saveUser")
	public void save(@RequestBody Map<String, String> record) {

		BloodGroup bloodGroup = bloodGroupRepository.findById(Integer.parseInt(record.get("bloodGroupId"))).get();

		District district = districtRepository.findById(Integer.parseInt(record.get("districtId"))).get();

		User user = new User(null, record.get("firstName"), record.get("middleName"), record.get("lastName"),
				record.get("dateOfBirth"), district, record.get("address"), record.get("gender"), bloodGroup,
				record.get("phoneNo"), record.get("email"), passwordEncoder.encode(record.get("password")));
		userRepository.save(user);

	}

	@GetMapping("users")
	public List<User> findUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;
	}

	@DeleteMapping("users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById((long) id);
	}

	@PutMapping("updateUser")
	public void updateUser(@RequestBody User user) {
		userRepository.save(user);
	}

	@GetMapping("users/{id}")
	public Optional<User> findUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
}
