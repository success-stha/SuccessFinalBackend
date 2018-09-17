package org.verscend.bbplus.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BloodCount implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Integer counter;

	@OneToOne
	@JoinColumn(name = "bloodGroupId")
	private BloodGroup bloodGroup;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCounter() {
		return counter;
	}

	public void setCounter(Integer counter) {
		this.counter = counter;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}
