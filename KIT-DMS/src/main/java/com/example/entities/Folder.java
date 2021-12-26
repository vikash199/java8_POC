package com.example.entities;

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
@Table(name="folder_mst")
public class Folder {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer folderId;
	
	@Column(name="folder_name")
	private String folderName;
	
	@Column(name = "created_date")
	private String createdDate;
	
	@Column (name = "updated_date")
	private String updatedDate;
	
	@OneToMany(mappedBy="folders",cascade={CascadeType.ALL})
	@PrimaryKeyJoinColumn
	private List<ProjectFolderMapping> projectFolderMapping;
	
	
	public Integer getFolderId() {
		return folderId;
	}
	public void setFolderId(Integer folderId) {
		this.folderId = folderId;
	}
	public String getFolderName() {
		return folderName;
	}
	public void setFolderName(String folderName) {
		this.folderName = folderName;
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
	public List<ProjectFolderMapping> getProjectFolderMapping() {
		return projectFolderMapping;
	}
	public void setProjectFolderMapping(List<ProjectFolderMapping> projectFolderMapping) {
		this.projectFolderMapping = projectFolderMapping;
	}
	
	
	

}
