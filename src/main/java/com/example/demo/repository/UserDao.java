package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserDao extends JpaRepository<User, Integer>{

	public User findByName(String name);
}
