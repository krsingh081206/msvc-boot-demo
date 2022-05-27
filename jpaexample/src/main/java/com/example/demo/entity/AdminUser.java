package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "ADMIN_USERS_T")
public class AdminUser extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6220226124757793250L;

	@Column(name = "FIRSTNAME", nullable = false)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false)
	private String lastName;

	@Column(name = "EMAILID", nullable = false)
	private String email;

	@Column(name = "USERID", nullable = false)
	private String userId;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "ACTIVE_STATUS_FLAG")
	protected Boolean activeStatusFlag = Boolean.TRUE;

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = AdminRole.class)
	@JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	protected Set<AdminRole> roles = new HashSet<AdminRole>();

	@Column(name = "SECRET_KEY", nullable = true)
	private String secretKey;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public Boolean getActiveStatusFlag() {
		return activeStatusFlag;
	}

	public void setActiveStatusFlag(Boolean activeStatusFlag) {
		this.activeStatusFlag = activeStatusFlag;
	}

	public Set<AdminRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AdminRole> roles) {
		this.roles = roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	@Override
	public String toString() {
		return "CarnivalAdminUser [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", userId="
				+ userId + ", password=" + password + ", activeStatusFlag=" + activeStatusFlag + ", roles=" + roles
				+ ", secretKey=" + secretKey + "]";
	}

}
