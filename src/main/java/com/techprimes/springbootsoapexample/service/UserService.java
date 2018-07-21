package com.techprimes.springbootsoapexample.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.example.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private Map<String, User> users = new HashMap<>();

	@PostConstruct
	public void initializer() {
		User rajesh = new User();
		rajesh.setEmpID(101);
		rajesh.setName("Rajesh");
		rajesh.setSalary(520.2);

		User roshan = new User();
		roshan.setEmpID(102);
		roshan.setName("Roshan");
		roshan.setSalary(2500);

		User rohan = new User();
		rohan.setEmpID(103);
		rohan.setName("Rohan");
		rohan.setSalary(8500);

		users.put(rajesh.getName(), rajesh);
		users.put(roshan.getName(), roshan);
		users.put(rohan.getName(), rohan);
	}

	public User getUsers(String name) {
		System.out.println(users);
		return users.get(name);
	}

}
