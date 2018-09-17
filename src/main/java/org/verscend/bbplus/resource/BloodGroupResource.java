package org.verscend.bbplus.resource;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.BloodGroup;
import org.verscend.bbplus.repository.BloodGroupRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodGroupResource {

	@Autowired
	BloodGroupRepository bloodGroupRepository;

	@GetMapping("bloodtypes")
	public List<BloodGroup> getBlood() {
		List<BloodGroup> bloodTypeList = new ArrayList<>();
		bloodGroupRepository.findAll().forEach(bloodTypeList::add);
		return bloodTypeList;
	}
}
