package org.verscend.bbplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.BloodCount;
import org.verscend.bbplus.models.BloodGroup;

public interface BloodCountRepository extends CrudRepository<BloodCount, Long> {
	BloodCount findByBloodGroup(BloodGroup bloodGroup);

	@Query(value = "Select * from Blood_Count", nativeQuery = true)
	public List<BloodCount> getBloodCount();

}
