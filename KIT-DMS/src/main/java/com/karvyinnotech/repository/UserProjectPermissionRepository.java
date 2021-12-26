package com.karvyinnotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karvyinnotech.entities.UserProjectPermissionMapping;

public interface UserProjectPermissionRepository extends JpaRepository<UserProjectPermissionMapping, Integer>{

}
