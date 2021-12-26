package com.example.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.FolderDto;
import com.example.dto.ProjectDTO;
import com.example.entities.Folder;
import com.example.entities.Project;
import com.example.entities.ProjectFolderMapping;
import com.example.repository.FolderRepository;
import com.example.repository.ProjectFolderRepository;
import com.example.response.CommonResponse;
import com.example.response.FolderResponse;
import com.example.service.FolderService;
import com.example.util.ConstantsApi;

@Service
public class FolderServiceImpl implements FolderService{

	@Autowired
	FolderRepository folderRepo;
	
	@Autowired
	ProjectFolderRepository projectFolderRepo;
/*	
	@Override
	public CommonResponse createFolder(FolderDto folderDto) {
		CommonResponse response = new CommonResponse();

		try {

			Folder folder = folderRepo.findByfolderName(folderDto.getFolderName());

			if (folder == null) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String currentDate = dateFormat.format(date);

				Folder fold = new Folder();

				fold.setFolderName(folderDto.getFolderName());
				fold.setCreatedDate(currentDate);
				Folder savedFolder = folderRepo.save(fold);

				if (savedFolder != null) {
					ProjectFolderMapping projectFolder = new ProjectFolderMapping();
					
					Project project = new Project();
					project.setProjectId(folderDto.getProjectId());
					
					Folder folderMap = new Folder();
					folderMap.setFolderId(savedFolder.getFolderId());
						
					projectFolder.setProjects(project);
					projectFolder.setFolders(folderMap);
					
					projectFolderRepo.save(projectFolder);

					response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
					response.setMessage("Folder created successfully");
					response.setResponseCode(HttpServletResponse.SC_OK);

				} else {

					response.setStatus(ConstantsApi.API_FAIL_STATUS);
					response.setMessage("Something went wrong, Please try after some time");
					response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

				}

			} else {

				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("Folder Name already Exists");
				response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}*/
	
	
	
	

	@Override
	public FolderResponse getFolderList() {
		int count=0;
		FolderResponse response = new FolderResponse();
		try {

			List<FolderDto> folderList = new ArrayList<>();
			List<Folder> folders = folderRepo.findAll();

			FolderDto folderDto;
			for (Folder folder : folders) {
				folderDto = new FolderDto();

				folderDto.setFolderId(folder.getFolderId());
				folderDto.setFolderName(folder.getFolderName());
				
				folderDto.setCreatedDate(folder.getCreatedDate().substring(0, 10));
				folderDto.setSno(++count);
				folderList.add(folderDto);

			}

			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			response.setMessage("Folder list fetched successfully");
			response.setResponseCode(HttpServletResponse.SC_OK);
			response.setFolderList(folderList);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public CommonResponse createFolder(FolderDto folderDto) {
		CommonResponse response = new CommonResponse();

		try {
			Folder folderObj = folderRepo.findByfolderName(folderDto.getFolderName());

			if (folderObj == null) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String currentDate = dateFormat.format(date);

				Folder folder = new Folder();
				folder.setFolderName(folderDto.getFolderName());
				folder.setCreatedDate(currentDate);

				Folder saveFolder = folderRepo.save(folder);
				if (saveFolder != null) {

					response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
					response.setMessage("Folder created successfully");
					response.setResponseCode(HttpServletResponse.SC_OK);

				} else {

					response.setStatus(ConstantsApi.API_FAIL_STATUS);
					response.setMessage("Something went wrong, Please try after some time");
					response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

				}

			} else {

				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("Folder Name already Exists");
				response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

			}

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}

	@Override
	public FolderResponse getFolderByProject(ProjectDTO projectDto) {
		FolderResponse response = new FolderResponse();
		try {
			List<Folder> folderList = null;
			if(projectDto.getProjectId() != null){
			List<Integer> folderIds = projectFolderRepo.getFolderbyProject(projectDto.getProjectId(),true);
			if(folderIds.size() != 0){
			 folderList = folderRepo.getfolderByProject(folderIds);
			}else{
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("No Folder Assign To this Project");
				response.setResponseCode(HttpServletResponse.SC_CONFLICT);
				return response;
			}
			}
			
			if(folderList != null &&folderList.size() != 0){
			
				List<FolderResponse> list = new ArrayList<FolderResponse>();
			
			FolderResponse folderResponse;
			for(Folder folder: folderList){
				folderResponse = new FolderResponse();
				
				folderResponse.setFolderId(folder.getFolderId());
				folderResponse.setFolderName(folder.getFolderName());
				list.add(folderResponse);
			}
			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			response.setMessage("Successfully fetched the folder list");
			response.setResponseCode(HttpServletResponse.SC_OK);
			response.setFolderResponseList(list);
			}else{
				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("No Folder Assign To this Project");
				response.setResponseCode(HttpServletResponse.SC_CONFLICT);
			}
		} catch(Exception e) {
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage("Folder Not fetched");
			response.setResponseCode(HttpServletResponse.SC_CONFLICT);
			
		}
		
		return response;
	}

	
	
}
