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


import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ADMIN_ROLES_T")
public class AdminRole extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2844381860306809199L;

	@ManyToMany(mappedBy = "roles")
	@JsonBackReference
	protected Set<AdminUser> users = new HashSet<AdminUser>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ROLES_PERMISSIONS", joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id", referencedColumnName = "id"))
	protected Set<AdminPermission> permissions = new HashSet<AdminPermission>();


	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCR", nullable = false)
	private String description;
	
	@Column(name = "ROLE_PRIORITY", nullable = true)
	private Long priority;

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public Set<AdminPermission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<AdminPermission> permissions) {
		this.permissions = permissions;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<AdminUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AdminUser> users) {
		this.users = users;
	}
	

}
