package org.verscend.bbplus.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.verscend.bbplus.models.District;
import org.verscend.bbplus.repository.DistrictRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistrictResource {

	@Autowired
	DistrictRepository districtRepository;

	@GetMapping("districts")
	public List<District> getDistricts() {
		List<District> districts = new ArrayList<>();
		districtRepository.findAll().forEach(districts::add);
		return districts;

	}
}
