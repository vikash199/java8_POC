package com.karvyinnotech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karvyinnotech.dto.ProjectDTO;
import com.karvyinnotech.response.CommonResponse;
import com.karvyinnotech.response.ProjectListResponse;
import com.karvyinnotech.response.ProjectResponse;
import com.karvyinnotech.service.ProjectService;

@RestController
@RequestMapping(value="/api/project")
public class ProjectController {
	
	private final Logger logger = LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	ProjectService projectService;

	@PostMapping("/createProject")
	public CommonResponse createProject(@RequestBody ProjectDTO projectDto){
	logger.info("ProjectController :: createProject");
		return	projectService.createProject(projectDto);
	}
	
	@GetMapping("/getProjectList")
	public ProjectResponse getProjectList(){
		logger.info("ProjectController  ||  getProjectList");
		return projectService.fetchProjectList();
	}
	
	@PostMapping("/editProject")
	CommonResponse editProject(@RequestBody ProjectDTO projectDto){
		logger.info("ProjectController  || editProject");
		return projectService.editProject(projectDto);
	}
	@GetMapping("/getlistWithFolders")
	ProjectListResponse getProjectListWithFolder(){
		logger.info("ProjectController ||  getProjectListWithFolder");
		return projectService.getProjectListWithFolders();
	}
	
}
