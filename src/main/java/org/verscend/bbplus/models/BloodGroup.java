package org.verscend.bbplus.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BloodGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bloodGroupId;
	private String bloodType;

	public BloodGroup() {
	}

	public BloodGroup(int bloodGroupId, String bloodType) {
		super();
		this.bloodGroupId = bloodGroupId;
		this.bloodType = bloodType;
	}

	public int getBloodGroupId() {
		return bloodGroupId;
	}

	public void setBloodGroupId(int bloodGroupId) {
		this.bloodGroupId = bloodGroupId;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	@Override
	public String toString() {
		return "BloodGroupRepository [bloodGroupId=" + bloodGroupId + ", bloodType=" + bloodType + "]";
	}

}
