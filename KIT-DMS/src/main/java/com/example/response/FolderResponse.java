package com.example.response;

import java.util.List;

import com.example.dto.FolderDto;

public class FolderResponse extends RestResponse{
	
	private Integer folderId;
	private String folderName;
	private Integer totalRecords;
	private List<FolderDto> folderList;
	private List<FolderResponse> folderResponseList;
	
	
	
	public List<FolderResponse> getFolderResponseList() {
		return folderResponseList;
	}
	public void setFolderResponseList(List<FolderResponse> folderResponseList) {
		this.folderResponseList = folderResponseList;
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
	public Integer getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(Integer totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<FolderDto> getFolderList() {
		return folderList;
	}
	public void setFolderList(List<FolderDto> folderList) {
		this.folderList = folderList;
	}
	
	
	

}
