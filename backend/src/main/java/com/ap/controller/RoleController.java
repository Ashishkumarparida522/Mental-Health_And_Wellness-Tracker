package com.ap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.entity.Role;
import com.ap.service.UserRoleservice;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
	
	   @Autowired
	    private UserRoleservice roleService;

	    
	    @PostMapping
	    public Role createRole(@RequestBody Role role) {
	        return roleService.saveRole(role);
	    }

	    @GetMapping
	    public List<Role> getAllRoles() {
	        return roleService.getAllRole();
	    }

	    @GetMapping("/{name}")
	    public Role getRoleByName(@PathVariable String name) {
	        return roleService.findByName(name);
	    }

}
