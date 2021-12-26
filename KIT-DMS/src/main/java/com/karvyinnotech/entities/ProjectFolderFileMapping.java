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
@Table(name = "project_folder_files")
public class ProjectFolderFileMapping {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private Integer projectFoldersFilesId;
	
	
	
	@ManyToOne
	@JoinColumn(name = "project_folder_id")
	private ProjectFolderMapping projectfolderMapping;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name="file_path")
	private String filePath;
	
	@Column(name = "version")
	private String version;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "creatdDate")
	private String createdDate;
	
	@Column(name = "updated_date")
	private String updatedDate;
	
	@Column(name="status")
	private Boolean status;

	public Integer getProjectFoldersFilesId() {
		return projectFoldersFilesId;
	}

	public void setProjectFoldersFilesId(Integer projectFoldersFilesId) {
		this.projectFoldersFilesId = projectFoldersFilesId;
	}

	
	

	
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
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

	

	public ProjectFolderMapping getProjectfolderMapping() {
		return projectfolderMapping;
	}

	public void setProjectfolderMapping(ProjectFolderMapping projectfolderMapping) {
		this.projectfolderMapping = projectfolderMapping;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
}
