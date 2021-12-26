package com.karvyinnotech.service;

import org.springframework.web.multipart.MultipartFile;

import com.karvyinnotech.dto.DocumentDto;
import com.karvyinnotech.response.CommonResponse;
import com.karvyinnotech.response.DocumentListResponse;

public interface DocumentService {
	
	CommonResponse uploadDocument(MultipartFile[] document, String documentDto);
	
	DocumentListResponse getDocumentList(DocumentDto documentDto);
	
	CommonResponse deletDocument(DocumentDto documentDto);
	
	

}
