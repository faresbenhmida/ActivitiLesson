package com.example.demo.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserDelegateService implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("Java Delegate Service Task executed successfully.");

		System.out.println("And the Sum of 2 + 2= " + (2 + 2));		
	}


}
