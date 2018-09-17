package org.verscend.bbplus.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.verscend.bbplus.models.BloodRecord;

public interface BloodRecordRepository extends CrudRepository<BloodRecord, Integer> {

//@Query(
// select entry_date, blood_type, sum(pint) from blood_record
// inner join blood_group on blood_record.blood_group_id=blood_group.blood_group_id
// where entry_date between 'fromDate' and 'toDate' group by blood_type)

	@Query(value = "select entry_date, blood_type, sum(pint) as sum from blood_record"
			+ " inner join blood_group on blood_record.blood_group_id=blood_group.blood_group_id"
			+ " where entry_date between ?1 and ?2 group by blood_type", nativeQuery = true)
	List<Map<String, Object>> dateBasedRecord(String fromDate, String toDate);

	@Query(value = "update dummy set sum=sum-?2 where blood_type=?1", nativeQuery = true)
	void deleteInDummy(String bloodType, long pint);

}