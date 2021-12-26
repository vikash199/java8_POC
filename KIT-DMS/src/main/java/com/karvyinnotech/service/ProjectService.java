package com.karvyinnotech.service;

import com.karvyinnotech.dto.ProjectDTO;
import com.karvyinnotech.response.CommonResponse;
import com.karvyinnotech.response.ProjectListResponse;
import com.karvyinnotech.response.ProjectResponse;

public interface ProjectService {
	
	CommonResponse createProject(ProjectDTO projectDto);
	
	ProjectResponse fetchProjectList();

	
	
	CommonResponse editProject(ProjectDTO projectdto);
	
	
	ProjectListResponse getProjectListWithFolders();
	
}
