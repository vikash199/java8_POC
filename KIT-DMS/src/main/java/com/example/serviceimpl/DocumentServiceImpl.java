package com.example.serviceimpl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.dto.DocumentDto;
import com.example.dto.FolderDto;
import com.example.entities.Folder;
import com.example.entities.ProjectFolderFileMapping;
import com.example.entities.ProjectFolderMapping;
import com.example.repository.ProjectFolderFileRepository;
import com.example.repository.ProjectFolderRepository;
import com.example.response.CommonResponse;
import com.example.response.DocumentListResponse;
import com.example.response.DocumentResponse;
import com.example.service.DocumentService;
import com.example.util.ConstantsApi;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DocumentServiceImpl implements DocumentService{
	
	@Autowired
	ProjectFolderRepository projectFolderRepo;
	
	@Autowired
	ProjectFolderFileRepository projectFolderFileRepo;

	@Override
	public CommonResponse uploadDocument(MultipartFile[] document, String documentDto) {
		CommonResponse commonResponse = new CommonResponse();

		try{

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);

			
			for(MultipartFile a : document){
				System.out.println("  file sixe max is "+a.getSize());
			}
			
		DocumentDto documentObj;
		ObjectMapper mapper = new ObjectMapper();
		
		documentObj = mapper.readValue(documentDto, DocumentDto.class);
		
		ProjectFolderMapping projectFolderMapping = projectFolderRepo.getProjectFolderDetails(documentObj.getProjectId(), documentObj.getFolderId());
		
		if(projectFolderMapping != null){
			
			ProjectFolderFileMapping fileUpload;
			ProjectFolderFileMapping projectFolderFileSave=null;	
			
			StringBuffer list = new StringBuffer();
			String fileName = null;
			String fileType=null;
			for (MultipartFile uploadedFile : document) {
				fileUpload = new ProjectFolderFileMapping();
				File files = new File(
						ConstantsApi.UPLOADED_FOLDER +uploadedFile.getOriginalFilename());
				fileName = uploadedFile.getOriginalFilename();
				fileType=uploadedFile.getContentType();
				System.out.println("total file size      "+uploadedFile.getSize());
				System.out.println(fileType);
				try {
					uploadedFile.transferTo(files);
					if(list.length()==0){
						list.append(files.toString());
					}
					else{
						list.append(","+files.toString());
					}
				} catch (IllegalStateException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				
				String docAtt= list.toString();
				docAtt=docAtt.replace(ConstantsApi.UPLOADED_FOLDER, ConstantsApi.SAVED_FOLDER);
				
				fileUpload.setFileName(fileName);
				String[] a = docAtt.split(",");
				for(String i : a){
				fileUpload.setFilePath(i);
				}
				ProjectFolderMapping profolMapping = new ProjectFolderMapping();
				profolMapping.setProjectFolderId(projectFolderMapping.getProjectFolderId());
						
				
				fileUpload.setProjectfolderMapping(profolMapping);
				fileUpload.setCreatedDate(currentDate);
				fileUpload.setStatus(true);
			if(fileName != null && docAtt.length() != 0){
				 projectFolderFileSave = projectFolderFileRepo.save(fileUpload);
			}
			}
			
			
			if(projectFolderFileSave != null){
			commonResponse.setMessage("File Uploaded Successfully");
			commonResponse.setResponseCode(HttpServletResponse.SC_OK);
			commonResponse.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			}else{
				commonResponse.setMessage("File Not Uploded");
				commonResponse.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				commonResponse.setStatus(ConstantsApi.API_FAIL_STATUS);
			}
		}else{
			commonResponse.setMessage("Project And Folder Not Updated");
			commonResponse.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			commonResponse.setStatus(ConstantsApi.API_FAIL_STATUS);
		}
		
		}catch(Exception e){
			e.printStackTrace();
			commonResponse.setMessage("Something went wrong, Please try again");
			commonResponse.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			commonResponse.setStatus(ConstantsApi.API_FAIL_STATUS);
		}
		return commonResponse;
	}

	

	@Override
	public DocumentListResponse getDocumentList(DocumentDto documentDto) {
		DocumentListResponse response = new DocumentListResponse();
		List<DocumentResponse> documentResponseList = new ArrayList<>();
		
		
		try{
			Integer sno=0;
		ProjectFolderMapping getProjectFolderId = projectFolderRepo.getProjectFolderDetails(documentDto.getProjectId(),documentDto.getFolderId());
		if(getProjectFolderId != null){
			List<ProjectFolderFileMapping> fileList = projectFolderFileRepo.getFileListbyProjectAndFolderId(getProjectFolderId.getProjectFolderId(),true);
			
			DocumentResponse documentFileResponse;
			for(ProjectFolderFileMapping documentList : fileList){
				documentFileResponse = new DocumentResponse();
				documentFileResponse.setsNo(++sno);
				documentFileResponse.setDocumentNo(documentList.getProjectFoldersFilesId());
				documentFileResponse.setDocumentName(documentList.getFileName());
				documentFileResponse.setDocumentLocation(documentList.getFilePath());
				documentFileResponse.setUpdatedDate(documentList.getUpdatedDate());
				documentFileResponse.setCreatedDate(documentList.getCreatedDate().substring(0, 10));
				
				documentResponseList.add(documentFileResponse);
			}
			response.setMessage("File Uploaded Successfully");
			response.setResponseCode(HttpServletResponse.SC_OK);
			response.setDocumentlistResponse(documentResponseList);
			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		

		
		return response;
	}



	@Override
	public CommonResponse deletDocument(DocumentDto documentDto) {
		CommonResponse response = new CommonResponse();
		try {
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);

			
			if(documentDto.getDocumentId() != null){
			
			 ProjectFolderFileMapping fileMapping = projectFolderFileRepo.deletFile(documentDto.getDocumentId());
			 if(fileMapping != null){
				 fileMapping.setStatus(false);
				 fileMapping.setUpdatedDate(currentDate);
				 
				 ProjectFolderFileMapping saveFile  = projectFolderFileRepo.save(fileMapping);
					if(saveFile != null){
						response.setMessage("File deleted Successfully");
						response.setResponseCode(HttpServletResponse.SC_OK);
						response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
					}else{
						response.setStatus(ConstantsApi.API_FAIL_STATUS);
						response.setMessage("File Not Found");
						response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}

			 }
			
			
			
			
			
			}else{
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("File Not Found");
				response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			}
			
		
			

		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	
	 private static String getSize(long size) {
	        long n = 1000;
	        String s = "";
	        double kb = size / n;
	        double mb = kb / n;
	        double gb = mb / n;
	        double tb = gb / n;
	        if(size < n) {
	            s = size + " Bytes";
	        } else if(size >= n && size < (n * n)) {
	            s =  String.format("%.2f", kb) + " KB";
	        } else if(size >= (n * n) && size < (n * n * n)) {
	            s = String.format("%.2f", mb) + " MB";
	        } else if(size >= (n * n * n) && size < (n * n * n * n)) {
	            s = String.format("%.2f", gb) + " GB";
	        } else if(size >= (n * n * n * n)) {
	            s = String.format("%.2f", tb) + " TB";
	        }
	        return s;
	    }

}
