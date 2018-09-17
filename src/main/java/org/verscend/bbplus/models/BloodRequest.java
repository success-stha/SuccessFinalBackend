package org.verscend.bbplus.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class BloodRequest implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bloodRequestId;
	@OneToOne
	@JoinColumn(name = "bloodGroupId")
	private BloodGroup bloodGroup;
	private long pint;
	private boolean status;
	private String email;

	public BloodRequest() {
	}

	public BloodRequest(Integer bloodRequestId, BloodGroup bloodGroup, long pint, boolean status, String email) {
		super();
		this.bloodRequestId = bloodRequestId;
		this.bloodGroup = bloodGroup;
		this.pint = pint;
		this.status = status;
		this.email = email;
	}

	public Integer getBloodRequestId() {
		return bloodRequestId;
	}

	public void setBloodRequestId(Integer bloodRequestId) {
		this.bloodRequestId = bloodRequestId;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getPint() {
		return pint;
	}

	public void setPint(long pint) {
		this.pint = pint;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
