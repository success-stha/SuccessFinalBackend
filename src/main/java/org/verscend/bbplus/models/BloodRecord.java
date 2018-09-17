package org.verscend.bbplus.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BloodRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bloodRecordId;

	@OneToOne
	@JoinColumn(name = "bloodGroupId")
	private BloodGroup bloodGroup;
	private long pint;
	private String donorName;
	private long donorPhone;
	@Temporal(TemporalType.DATE)
	private Date entryDate = new Date();

	public BloodRecord() {
	}

	public BloodRecord(Integer bloodRecordId, BloodGroup bloodGroup, long pint, String donorName, long donorPhone) {
		super();
		this.bloodRecordId = bloodRecordId;
		this.bloodGroup = bloodGroup;
		this.pint = pint;
		this.donorName = donorName;
		this.donorPhone = donorPhone;
	}

	public Integer getBloodRecordId() {
		return bloodRecordId;
	}

	public void setBloodRecordId(Integer bloodRecordId) {
		this.bloodRecordId = bloodRecordId;
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

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public Date getEntryDate() {
		return entryDate;
	}

//	public void setEntryDate(Date entryDate) {
//		this.entryDate = entryDate;
//	}

	public long getDonorPhone() {
		return donorPhone;
	}

	public void setDonorPhone(long donorPhone) {
		this.donorPhone = donorPhone;
	}

}