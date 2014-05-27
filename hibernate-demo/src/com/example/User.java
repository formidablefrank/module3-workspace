package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	private Long key_user;
	private Long key_role;
	private String fld_username;
	private String fld_password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getKey_user() {
		return key_user;
	}
	public void setKey_user(Long key_user) {
		this.key_user = key_user;
	}
	public Long getKey_role() {
		return key_role;
	}
	public void setKey_role(Long key_role) {
		this.key_role = key_role;
	}
	public String getFld_username() {
		return fld_username;
	}
	public void setFld_username(String fld_username) {
		this.fld_username = fld_username;
	}
	public String getFld_password() {
		return fld_password;
	}
	public void setFld_password(String fld_password) {
		this.fld_password = fld_password;
	}
	public User(Long key_user, Long key_role, String fld_username,
			String fld_password) {
		super();
		this.key_user = key_user;
		this.key_role = key_role;
		this.fld_username = fld_username;
		this.fld_password = fld_password;
	}
	@Override
	public String toString() {
		return "tbl_user [key_user=" + key_user + ", key_role=" + key_role
				+ ", fld_username=" + fld_username + ", fld_password="
				+ fld_password + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fld_password == null) ? 0 : fld_password.hashCode());
		result = prime * result
				+ ((fld_username == null) ? 0 : fld_username.hashCode());
		result = prime * result
				+ ((key_role == null) ? 0 : key_role.hashCode());
		result = prime * result
				+ ((key_user == null) ? 0 : key_user.hashCode());
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
		User other = (User) obj;
		if (fld_password == null) {
			if (other.fld_password != null)
				return false;
		} else if (!fld_password.equals(other.fld_password))
			return false;
		if (fld_username == null) {
			if (other.fld_username != null)
				return false;
		} else if (!fld_username.equals(other.fld_username))
			return false;
		if (key_role == null) {
			if (other.key_role != null)
				return false;
		} else if (!key_role.equals(other.key_role))
			return false;
		if (key_user == null) {
			if (other.key_user != null)
				return false;
		} else if (!key_user.equals(other.key_user))
			return false;
		return true;
	}
	public User(){
		
	}
}
