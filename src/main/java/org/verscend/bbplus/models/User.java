package org.verscend.bbplus.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.verscend.bbplus.privilege.Role;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 20172018L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	private String firstName;
	private String middleName;
	private String lastName;
	private String dateOfBirth;
	@OneToOne
	@JoinColumn(name = "districtId")
	private District district;
	private String address;
	private String gender;
	@OneToOne
	@JoinColumn(name = "bloodGroupId")
	private BloodGroup bloodGroup;
	private String phoneNo;
	private String role = "USER";
	private String email;
	private String password;

	public User() {
	}

	public User(Long userId, String firstName, String middleName, String lastName, String dateOfBirth,
			District district, String address, String gender, BloodGroup bloodGroup, String phoneNo, String email,
			String password) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.district = district;
		this.address = address;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}