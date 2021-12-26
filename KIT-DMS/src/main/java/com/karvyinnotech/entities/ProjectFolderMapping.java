package com.karvyinnotech.entities;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "project_folder_t")
public class ProjectFolderMapping {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer projectFolderId;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project projects;
	
	@ManyToOne
	@JoinColumn(name="folder_id")
	private Folder folders;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column(name ="updated_date")
	private String updatedDate;
	
	@Column(name="status")	
	private Boolean status;
	
	@OneToMany(mappedBy="projectfolderMapping",cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private List<ProjectFolderFileMapping> projectFolderFileMapping;
	
	
	
	public Integer getProjectFolderId() {
		return projectFolderId;
	}
	public void setProjectFolderId(Integer projectFolderId) {
		this.projectFolderId = projectFolderId;
	}
	public Project getProjects() {
		return projects;
	}
	public void setProjects(Project projects) {
		this.projects = projects;
	}
	public Folder getFolders() {
		return folders;
	}
	public void setFolders(Folder folders) {
		this.folders = folders;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public List<ProjectFolderFileMapping> getProjectFolderFileMapping() {
		return projectFolderFileMapping;
	}
	public void setProjectFolderFileMapping(List<ProjectFolderFileMapping> projectFolderFileMapping) {
		this.projectFolderFileMapping = projectFolderFileMapping;
	}
	
	
	
}
