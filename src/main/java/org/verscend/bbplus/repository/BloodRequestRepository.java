package org.verscend.bbplus.repository;

import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.BloodRequest;

public interface BloodRequestRepository extends CrudRepository<BloodRequest, Integer> {

	BloodRequest findByEmail(String email);

}
