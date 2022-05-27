package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "ADMIN_PERMISSIONS_T")
public class AdminPermission extends AbstractEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8275687525628257083L;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "DESCR", nullable = false)
	private String description;	

	
	@ManyToMany(mappedBy = "permissions")
	@JsonBackReference
	protected Set<AdminRole> roles = new HashSet<AdminRole>();

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


	public Set<AdminRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AdminRole> roles) {
		this.roles = roles;
	}

}
