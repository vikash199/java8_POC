package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.dto.DocumentDto;
import com.example.response.CommonResponse;
import com.example.response.DocumentListResponse;

public interface DocumentService {
	
	CommonResponse uploadDocument(MultipartFile[] document, String documentDto);
	
	DocumentListResponse getDocumentList(DocumentDto documentDto);
	
	CommonResponse deletDocument(DocumentDto documentDto);
	
	

}
