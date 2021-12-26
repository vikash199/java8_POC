package com.example.service;

import com.example.dto.ProjectDTO;
import com.example.response.CommonResponse;
import com.example.response.ProjectListResponse;
import com.example.response.ProjectResponse;

public interface ProjectService {
	
	CommonResponse createProject(ProjectDTO projectDto);
	
	ProjectResponse fetchProjectList();

	
	
	CommonResponse editProject(ProjectDTO projectdto);
	
	
	ProjectListResponse getProjectListWithFolders();
	
}
