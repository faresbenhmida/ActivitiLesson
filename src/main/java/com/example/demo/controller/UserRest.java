package com.example.demo.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserRest {

	@Autowired
	private UserService service;
	
	@GetMapping("/start")
	public User StartProcess() {
		User user = service.Start();
		return user;
	}
	@GetMapping("/next")
	public String NextProcess() {
		 service.next();
		return "Done";
	}
}
