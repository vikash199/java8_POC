package com.karvyinnotech.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_project_t")
public class UserProjectPermissionMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer userProjectPermissionId;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User users;
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project projects;
	
	@ManyToOne
	@JoinColumn(name="permission_id")
	private Permission permissions;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;

	public Integer getUserProjectPermissionId() {
		return userProjectPermissionId;
	}

	public void setUserProjectPermissionId(Integer userProjectPermissionId) {
		this.userProjectPermissionId = userProjectPermissionId;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Project getProjects() {
		return projects;
	}

	public void setProjects(Project projects) {
		this.projects = projects;
	}

	public Permission getPermissions() {
		return permissions;
	}

	public void setPermissions(Permission permissions) {
		this.permissions = permissions;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
}
