package com.example.dto;

import java.util.List;

public class ProjectDTO {
	
	private Integer projectId;
	private String projectName;
	private String description;
	private List<Integer> folderId;
	private List<String> folderName;
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
	public List<Integer> getFolderId() {
		return folderId;
	}
	public void setFolderId(List<Integer> folderId) {
		this.folderId = folderId;
	}
	public List<String> getFolderName() {
		return folderName;
	}
	public void setFolderName(List<String> folderName) {
		this.folderName = folderName;
	}
	
	

	
	

}
