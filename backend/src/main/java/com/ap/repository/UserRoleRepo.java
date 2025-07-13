package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.Role;

public interface UserRoleRepo extends JpaRepository<Role,Integer> {
	
	public Role findByName(String name);
	

}
