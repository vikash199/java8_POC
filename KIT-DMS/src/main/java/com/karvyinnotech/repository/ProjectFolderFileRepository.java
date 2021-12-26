package com.karvyinnotech.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.karvyinnotech.entities.ProjectFolderFileMapping;

public interface ProjectFolderFileRepository extends JpaRepository<ProjectFolderFileMapping, Integer>{
	
	@Query(nativeQuery=true,value="select * from project_folder_files where project_folder_id=?1 and status=?2")
	List<ProjectFolderFileMapping> getFileListbyProjectAndFolderId(Integer projectFolderId, Boolean status);

	
	@Query(nativeQuery=true,value="select * from project_folder_files where id=?1")
	ProjectFolderFileMapping deletFile(Integer fileId);
	
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "delete FROM project_folder_files where id = ?1")
	int deleteByProjectFolerFileId(Integer documentId);
}
