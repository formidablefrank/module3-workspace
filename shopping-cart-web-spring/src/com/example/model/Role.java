package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_role")
public class Role {
	private Long id;
	private String roleType;
	
	public Role(){}
	
	public Role(Long id, String roleType) {
		super();
		this.id = id;
		this.roleType = roleType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((roleType == null) ? 0 : roleType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (roleType == null) {
			if (other.roleType != null)
				return false;
		} else if (!roleType.equals(other.roleType))
			return false;
		return true;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_role")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name="fld_roletype")
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleName) {
		this.roleType = roleName;
	}
	
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleType=" + roleType + "]";
	}
	
	
}
