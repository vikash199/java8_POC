package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>,JpaSpecificationExecutor<Project>{
	
	Project findByProjectName(String projectName);
	
	Project findByProjectId(Integer projectId);
	
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "update project_mst_t set name = ?1 where id = ?2")	
	int updatedProject(String projectName , Integer projectId);

}
