package com.karvyinnotech.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karvyinnotech.dto.FolderDto;
import com.karvyinnotech.dto.ProjectDTO;
import com.karvyinnotech.response.CommonResponse;
import com.karvyinnotech.response.FolderResponse;
import com.karvyinnotech.service.FolderService;

@RestController
@RequestMapping(value="/api/folder")
public class FolderController {
	private final Logger logger = LoggerFactory.getLogger(FolderController.class);
	
	@Autowired
	FolderService folderservice;
	
	
	@PostMapping("/createfolder")
	public CommonResponse createProject(@RequestBody FolderDto folderDto){
	logger.info("FolderController :: createFolder");
		return	folderservice.createFolder(folderDto);
	}
	
	@GetMapping("/getFolderlist")
	public FolderResponse getFolderList(){
		logger.info("FolderController || getFolderList");
		return folderservice.getFolderList();
	}
	
	@PostMapping("/folderListbyProject")
	public FolderResponse getFolderbyProject(@RequestBody ProjectDTO projectDto){
		logger.info("FolderController  || getFolderByProject");
		return folderservice.getFolderByProject(projectDto);
	}

}
