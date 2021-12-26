package com.karvyinnotech.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "project_mst_t")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer projectId;
	
	@Column(name = "name")
	private String projectName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;

	@OneToMany(mappedBy="projects", cascade= {CascadeType.ALL})
	@PrimaryKeyJoinColumn
	List<UserProjectPermissionMapping> userProjectPermissionMapping;
	
	@OneToMany(mappedBy = "projects", cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	List<ProjectFolderMapping> projectFolderMapping;
	
	public List<UserProjectPermissionMapping> getUserProjectPermissionMapping() {
		return userProjectPermissionMapping;
	}

	public void setUserProjectPermissionMapping(List<UserProjectPermissionMapping> userProjectPermissionMapping) {
		this.userProjectPermissionMapping = userProjectPermissionMapping;
	}

	public List<ProjectFolderMapping> getProjectFolderMapping() {
		return projectFolderMapping;
	}

	public void setProjectFolderMapping(List<ProjectFolderMapping> projectFolderMapping) {
		this.projectFolderMapping = projectFolderMapping;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
