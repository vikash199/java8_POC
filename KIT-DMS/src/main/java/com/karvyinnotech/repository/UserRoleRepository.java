package com.karvyinnotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.karvyinnotech.entities.User;
import com.karvyinnotech.entities.UserRoleMapping;

public interface UserRoleRepository extends JpaRepository<UserRoleMapping, Integer>{
	
	UserRoleMapping findByUsers(User user);

}
