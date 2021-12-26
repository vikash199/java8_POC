package com.karvyinnotech.service;

import com.karvyinnotech.dto.FolderDto;
import com.karvyinnotech.dto.ProjectDTO;
import com.karvyinnotech.response.CommonResponse;
import com.karvyinnotech.response.FolderResponse;

public interface FolderService {
	
	CommonResponse createFolder(FolderDto folderDto);
	
	FolderResponse getFolderList();
	
	FolderResponse getFolderByProject(ProjectDTO projectDto);

}
