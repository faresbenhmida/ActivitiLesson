package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MethodExpressionService {
	public void myService() {

		System.out.println("Method Expression Service Task executed successfully.");

		System.out.println("And the Multiply of 2 * 2= " + (2 * 2));
	}
}
