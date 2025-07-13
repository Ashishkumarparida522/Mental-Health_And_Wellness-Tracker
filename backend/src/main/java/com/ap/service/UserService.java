package com.ap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ap.entity.User;
import com.ap.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo user;
	
	public User saveUser(User user)
	{
		return this.user.save(user);
	}
	
	public List<User> getAllUser()
	{
		return user.findAll();
	}
	public Optional<User> getUserById(Integer id)
	{
		return user.findById(id);
		
	}
	 public boolean deleteUser(Integer id) {
	        if (user.existsById(id)) {
	            user.deleteById(id);
	            return true;
	        }
	        return false;
	    }
	}
	
	
	


