package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entities.Folder;

public interface FolderRepository extends JpaRepository<Folder, Integer>{
	
	Folder findByfolderName(String folderName);
	
	@Query(nativeQuery=true,value="select * from folder_mst where id in (?1)")
	List<Folder> getfolderByProject(List<Integer> folderIds);

}
