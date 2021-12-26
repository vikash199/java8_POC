package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.DocumentDto;
import com.example.response.CommonResponse;
import com.example.response.DocumentListResponse;
import com.example.service.DocumentService;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

	@Autowired
	DocumentService documentService;
	
	private final Logger logger = LoggerFactory.getLogger(DocumentController.class);
	
	@PostMapping("/uploadDocument")
	public CommonResponse uploadDocument(@RequestParam("document") MultipartFile[] document,@RequestParam("documentDto") String documentDto){
		
		logger.info("DocumentController ||  uploadDocument");
		return documentService.uploadDocument(document, documentDto);
		
	}
	
	@PostMapping("/list")
	public DocumentListResponse getDocumentList(@RequestBody DocumentDto documentDto){
		logger.info("DocumentCotroller || getDocumentList");
		return documentService.getDocumentList(documentDto);
	}
	
	@PostMapping("/deletFile")
	public CommonResponse deletDocument(@RequestBody DocumentDto documentDto){
		logger.info("DocumentCotroller || deletDocument");
		return documentService.deletDocument(documentDto);
	}
	
}
