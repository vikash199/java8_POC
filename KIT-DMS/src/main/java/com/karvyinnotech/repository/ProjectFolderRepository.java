package com.karvyinnotech.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.karvyinnotech.entities.ProjectFolderMapping;

public interface ProjectFolderRepository extends JpaRepository<ProjectFolderMapping, Integer>{

	@Query(nativeQuery=true,value="select folder_id from project_folder_t where project_id=?1 and status=?2")
	List<Integer> getFolderbyProject(Integer projectId,Boolean status);
	
	@Query(nativeQuery=true,value="select * from project_folder_t where project_id=?1 and folder_id=?2")
	ProjectFolderMapping getProjectFolderDetails(Integer projectId,Integer folderId);
	
	@Query(nativeQuery=true,value="select * from project_folder_t where project_id=?1")
	List<ProjectFolderMapping> getProjectFolderDetailsByProject(Integer projectId);
	
	
	@Query(nativeQuery=true,value="select * from project_folder_t where id=?1")
	ProjectFolderMapping getProjectFolderDetailsId(Integer projectId);
	
			
			@Query(nativeQuery=true, value="SELECT * FROM project_folder_t where status=?1")
			List<ProjectFolderMapping> getprojectFolderList(Boolean status);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "delete FROM project_folder_t where project_id = ?1")
	void deleteByProjectId(Integer projectId);

	
	
	
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update project_folder_t set status = ?1 and updated_date=?2 where id = ?3")	
	int updatedProjectFolder(Boolean status ,String updatedDate, Integer projectFolderId);

	
}
