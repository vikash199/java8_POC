package com.karvyinnotech.response;

import java.util.List;

import com.karvyinnotech.dto.ProjectDTO;

public class ProjectResponse extends RestResponse{
	
	private Integer projectId;
	private String prjectName;
	
	private Integer folderId;
	private String folderName;
	
	private Integer totalProjectCount;
	private List<ProjectDTO> projecdtList;
	private List<Integer> folderListId;
	
	
	
	
	public List<Integer> getFolderListId() {
		return folderListId;
	}
	public void setFolderListId(List<Integer> folderListId) {
		this.folderListId = folderListId;
	}
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public String getPrjectName() {
		return prjectName;
	}
	public void setPrjectName(String prjectName) {
		this.prjectName = prjectName;
	}
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
	public Integer getTotalProjectCount() {
		return totalProjectCount;
	}
	public void setTotalProjectCount(Integer totalProjectCount) {
		this.totalProjectCount = totalProjectCount;
	}
	public List<ProjectDTO> getProjecdtList() {
		return projecdtList;
	}
	public void setProjecdtList(List<ProjectDTO> projecdtList) {
		this.projecdtList = projecdtList;
	}
	
	
	

}
