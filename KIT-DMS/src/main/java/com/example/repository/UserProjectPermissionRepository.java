package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.UserProjectPermissionMapping;

public interface UserProjectPermissionRepository extends JpaRepository<UserProjectPermissionMapping, Integer>{

}
