package org.verscend.bbplus.privilege;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role implements Serializable {

	private static final long serialVersionUID = 890245234L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int roleId;

	private String name;

	public Role() {
	}

	public Role(int roleId, String name) {
		super();
		this.roleId = roleId;
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
