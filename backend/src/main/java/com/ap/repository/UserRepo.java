package com.ap.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ap.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
