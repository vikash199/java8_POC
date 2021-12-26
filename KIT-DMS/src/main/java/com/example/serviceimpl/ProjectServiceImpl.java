package com.example.serviceimpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ProjectDTO;
import com.example.entities.Folder;
import com.example.entities.Project;
import com.example.entities.ProjectFolderMapping;
import com.example.repository.ProjectFolderRepository;
import com.example.repository.ProjectRepository;
import com.example.response.CommonResponse;
import com.example.response.ProjectListResponse;
import com.example.response.ProjectResponse;
import com.example.service.ProjectService;
import com.example.util.ConstantsApi;

@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectFolderRepository projectFolderRepo;
	
	@Override
	public CommonResponse createProject(ProjectDTO projectDto) {
		CommonResponse response = new CommonResponse();

		try {
			Project projectb = projectRepo.findByProjectName(projectDto.getProjectName());

			if (projectb == null) {

				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String currentDate = dateFormat.format(date);

				Project pro = new Project();
				pro.setProjectName(projectDto.getProjectName());
				pro.setCreatedDate(currentDate);

				Project savedProject = projectRepo.save(pro);

				if (savedProject != null) {
					
					ProjectFolderMapping projectFolderObj;
					
					for(Integer i : projectDto.getFolderId()){
						projectFolderObj = new ProjectFolderMapping();
						
						Folder folderObj = new Folder();
						folderObj.setFolderId(i);
						
						Project projectObj = new Project();
						projectObj.setProjectId(savedProject.getProjectId());
						
						projectFolderObj.setProjects(projectObj);
						projectFolderObj.setFolders(folderObj);
						projectFolderObj.setStatus(true);
						projectFolderObj.setCreatedDate(currentDate);
						
						projectFolderRepo.save(projectFolderObj);
				
					}
					

					response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
					response.setMessage("Project created successfully");
					response.setResponseCode(HttpServletResponse.SC_OK);

				} else {

					response.setStatus(ConstantsApi.API_FAIL_STATUS);
					response.setMessage("Something went wrong, Please try after some time");
					response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

				}

			} else {

				response.setStatus(ConstantsApi.API_FAIL_STATUS);
				response.setMessage("Project Name already Exists");
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
	public ProjectResponse fetchProjectList() {

		ProjectResponse response = new ProjectResponse();
		try {

			List<ProjectDTO> projectList = new ArrayList<>();
			List<Project> projects = projectRepo.findAll();

			ProjectDTO projectDto;
			for (Project project : projects) {
				projectDto = new ProjectDTO();


				projectDto.setProjectId(project.getProjectId());
				projectDto.setProjectName(project.getProjectName());
				
				projectList.add(projectDto);

			}

			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			response.setMessage("Project list fetched successfully");
			response.setResponseCode(HttpServletResponse.SC_OK);
			response.setProjecdtList(projectList);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		
		return response;
	}

	

	/*@Override
	public CommonResponse editProject(ProjectDTO projectDto) {

		CommonResponse response = new CommonResponse();

		try {
			
			
			
			Project project = projectRepo.findByProjectId(projectDto.getProjectId());

			if(project.getProjectName() != projectDto.getProjectName()){
				  projectRepo.updatedProject(projectDto.getProjectName(), project.getProjectId());
			}
			
			
			
			
				DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date();
				String currentDate = dateFormat.format(date);
				if (project.getProjectFolderMapping().size() > 0) {
					projectFolderRepo.deleteByProjectId(project.getProjectId());
				}
					ProjectFolderMapping editFoldereditFoldereditFolder = new ProjectFolderMapping();
					Project projectObj;
					Folder folder;
					for (Integer editFolder : projectDto.getFolderId()) {
						editFoldereditFoldereditFolder = new ProjectFolderMapping();
						folder = new Folder();
						folder.setFolderId(editFolder);
						
						projectObj = new Project();
						projectObj.setProjectId(project.getProjectId());
						
						
						
						
						editFoldereditFoldereditFolder.setFolders(folder);
						editFoldereditFoldereditFolder.setProjects(projectObj);
						
						editFoldereditFoldereditFolder.setCreatedDate(currentDate);
						 projectFolderRepo.save(editFoldereditFoldereditFolder);

					}

					
					response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
					response.setMessage("User details edited successfully");
					response.setResponseCode(HttpServletResponse.SC_OK);

			

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}*/

	@Override
	public ProjectListResponse getProjectListWithFolders() {
		
		ProjectListResponse response = new ProjectListResponse();
		try{
			List<Project> proList = projectRepo.findAll();
			List<ProjectFolderMapping> projectFolderList = projectFolderRepo.getprojectFolderList(true);
			
			List<ProjectResponse> list = new ArrayList<>();
			
			ProjectResponse projectDetailResponse;
			for(Project projects : proList){
				projectDetailResponse = new ProjectResponse();
				
				
				StringBuffer folderName = new StringBuffer();
				List<Integer> folderId = new ArrayList<>();
				for(ProjectFolderMapping projectFolderMap : projectFolderList){
					
					if(projects.getProjectId().equals(projectFolderMap.getProjects().getProjectId())){
						projectDetailResponse.setProjectId(projectFolderMap.getProjects().getProjectId());
						projectDetailResponse.setPrjectName(projectFolderMap.getProjects().getProjectName());
						folderName.append(", ").append(projectFolderMap.getFolders().getFolderName());
						folderId.add(projectFolderMap.getFolders().getFolderId());
						projectDetailResponse.setFolderName(folderName.toString().substring(1));
						projectDetailResponse.setFolderListId(folderId);
					
						list.add(projectDetailResponse);
					
					}else{
						projectDetailResponse.setProjectId(projects.getProjectId());
						projectDetailResponse.setPrjectName(projects.getProjectName());
						list.add(projectDetailResponse);
					}
						
					
					
				}
				
				
			}
			List<ProjectResponse> projectlist =	list.stream().distinct().collect(Collectors.toList());
			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			response.setMessage("User details edited successfully");
			response.setProjectListResponse(projectlist);
			response.setResponseCode(HttpServletResponse.SC_OK);
			
		}catch(Exception e){
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
		
		return response;
	}

	@Override
	public CommonResponse editProject(ProjectDTO projectdto) {

		CommonResponse response = new CommonResponse();

		try {

			Project project = projectRepo.findByProjectId(projectdto.getProjectId());

			if (project.getProjectName() != projectdto.getProjectName()) {
				projectRepo.updatedProject(projectdto.getProjectName(), project.getProjectId());
			}

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			String currentDate = dateFormat.format(date);

			for (Integer aww : projectdto.getFolderId()) {
				ProjectFolderMapping m = projectFolderRepo.getProjectFolderDetails(projectdto.getProjectId(), aww);
				if (m == null) {
					ProjectFolderMapping newCreate = new ProjectFolderMapping();

					Project pro = new Project();
					pro.setProjectId(projectdto.getProjectId());

					Folder fol = new Folder();
					fol.setFolderId(aww);

					newCreate.setProjects(pro);
					newCreate.setFolders(fol);
					newCreate.setStatus(true);
					newCreate.setCreatedDate(currentDate);
					projectFolderRepo.save(newCreate);

				}
			}

			List<ProjectFolderMapping> totalProjectmap = projectFolderRepo
					.getProjectFolderDetailsByProject(projectdto.getProjectId());

			for (ProjectFolderMapping map : totalProjectmap) {

				for (Integer a : projectdto.getFolderId()) {
					ProjectFolderMapping m = projectFolderRepo.getProjectFolderDetails(projectdto.getProjectId(), a);

					if (map.getProjects().getProjectId().equals(m.getProjects().getProjectId())
							&& map.getFolders().getFolderId().equals(m.getFolders().getFolderId())) {
						//projectFolderRepo.updatedProjectFolder(true,currentDate, map.getProjectFolderId());
						ProjectFolderMapping update = projectFolderRepo.getProjectFolderDetailsId(m.getProjectFolderId());
						update.setStatus(true);
						update.setUpdatedDate(currentDate);
						projectFolderRepo.save(update);
						
						break;
					} else {

						//projectFolderRepo.updatedProjectFolder(false,currentDate, map.getProjectFolderId());
						
						ProjectFolderMapping updateStatus = projectFolderRepo.getProjectFolderDetailsId(map.getProjectFolderId());
						updateStatus.setStatus(false);
						updateStatus.setUpdatedDate(currentDate);
						projectFolderRepo.save(updateStatus);
					}

				}

			}

			response.setStatus(ConstantsApi.API_SUCCESS_STATUS);
			response.setMessage("User details edited successfully");
			response.setResponseCode(HttpServletResponse.SC_OK);

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(ConstantsApi.API_FAIL_STATUS);
			response.setMessage(e.getMessage());
			response.setResponseCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}

		return response;
	}
	
	
	
	
	
}
