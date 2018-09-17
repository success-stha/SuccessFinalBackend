package org.verscend.bbplus.resource;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.BloodCount;
import org.verscend.bbplus.models.BloodGroup;
import org.verscend.bbplus.models.BloodRequest;
import org.verscend.bbplus.repository.BloodCountRepository;
import org.verscend.bbplus.repository.BloodGroupRepository;
import org.verscend.bbplus.repository.BloodRequestRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodRequestResource {

	@Autowired
	BloodRequestRepository bloodRequestRepository;

	@Autowired
	BloodGroupRepository bloodGroupRepository;

	@Autowired
	BloodCountRepository bloodCountRepository;

	@PostMapping("saveBloodRequest")
	public void save(@RequestBody Map<String, String> record, Principal principal) {
		BloodGroup bloodGroup = bloodGroupRepository.findById(Integer.parseInt(record.get("bloodGroupId"))).get();
		BloodRequest bloodRequest = new BloodRequest(null, bloodGroup, Long.parseLong(record.get("pint")),
				Boolean.parseBoolean(record.get("status")), principal.getName());
		bloodRequestRepository.save(bloodRequest);
	}

	@GetMapping("requests")
	public List<BloodRequest> findBloodRequests() {
		List<BloodRequest> requestList = new ArrayList<>();
		bloodRequestRepository.findAll().forEach((data) -> {
			if (data.isStatus()) {
				requestList.add(data);
			}
		});
		return requestList;
	}

	@GetMapping("requests/{id}")
	public Optional<BloodRequest> findById(@PathVariable int id) {
		return bloodRequestRepository.findById(id);
	}

	@DeleteMapping("requests/{id}")
	public void deleteRequest(@PathVariable Integer id) {
		bloodRequestRepository.deleteById(id);
	}

	@PutMapping("updateRequest")
	public void updateRequest(@RequestBody BloodRequest bloodRequest) {
		bloodRequestRepository.save(bloodRequest);
	}

	@PostMapping("approve")
	public BloodRequest approveRequest(@RequestBody BloodRequest bloodRequest) {
		BloodGroup bloodGroup = new BloodGroup();
		bloodGroup.setBloodGroupId((bloodRequest.getBloodGroup().getBloodGroupId()));
		BloodCount bloodCount = this.bloodCountRepository.findByBloodGroup(bloodGroup);
		if (bloodCount != null) {
			int count = bloodCount.getCounter() - (int) bloodRequest.getPint();
			bloodCount.setCounter(count);
			this.bloodCountRepository.save(bloodCount);
			bloodRequest.setStatus(false);
			this.bloodRequestRepository.save(bloodRequest);
			bloodRequest.setStatus(true);
			return bloodRequest;
		}

		bloodRequest.setStatus(false);

		return bloodRequest;
	}

	@GetMapping("getBloodCount")
	public List<BloodCount> getBloodCount() {
		return bloodCountRepository.getBloodCount();

	}

}
