package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer>{

}
