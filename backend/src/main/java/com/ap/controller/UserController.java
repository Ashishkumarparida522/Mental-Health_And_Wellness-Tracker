package com.ap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ap.entity.User;
import com.ap.service.UserService;

@RestController
@RequestMapping("/user-api")
public class UserController
{
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/reg")
	public ResponseEntity<String> saveUser(@RequestBody User user)
	{
		User savedUser = userservice.saveUser(user);
		
		String message="userSaved with id"+user.getId();
		return new ResponseEntity<String>(message,HttpStatus.CREATED);//201
	}
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser()
	{
		List<User> allUser = userservice.getAllUser();
		
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	  @GetMapping("/users/{id}")
	    public ResponseEntity<?> getUserById(@PathVariable Integer id) {
	        Optional<User> userById = userservice.getUserById(id);
	        if (userById.isPresent()) {
	            return new ResponseEntity<>(userById.get(), HttpStatus.OK); // return the user
	        } else {
	            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND); // 404
	        }
	    }
	@DeleteMapping("/delete-user/{id}")
	public ResponseEntity<String> deletUserById(@PathVariable Integer id)
	{
		boolean deleteUser = userservice.deleteUser(id);
		if(deleteUser)
			return new ResponseEntity<String>("user deleted",HttpStatus.OK);
		else 
			return new ResponseEntity<String>("invalid id",HttpStatus.BAD_REQUEST);//401
	}
	
	
	
	

}
