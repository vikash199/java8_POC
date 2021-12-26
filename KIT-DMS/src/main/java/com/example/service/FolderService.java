package com.example.service;

import com.example.dto.FolderDto;
import com.example.dto.ProjectDTO;
import com.example.response.CommonResponse;
import com.example.response.FolderResponse;

public interface FolderService {
	
	CommonResponse createFolder(FolderDto folderDto);
	
	FolderResponse getFolderList();
	
	FolderResponse getFolderByProject(ProjectDTO projectDto);

}
