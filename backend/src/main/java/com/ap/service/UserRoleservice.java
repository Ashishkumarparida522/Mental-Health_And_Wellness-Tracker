package com.ap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.entity.Role;
import com.ap.repository.UserRoleRepo;

@Service
public class UserRoleservice {
	
@Autowired	
private UserRoleRepo userRoleRepo;

public Role saveRole(Role role)

{
	return userRoleRepo.save(role);
}

public List<Role> getAllRole()
{
	return userRoleRepo.findAll();
}
public Role findByName(String name )
{
	return userRoleRepo.findByName(name);
}
public Role getById(Integer id)
{
	return userRoleRepo.findById(id).orElse(null);
}

}
