package com.techprimes.springbootsoapexample.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.example.spring_boot_soap_example.GetUserRequest;
import org.example.spring_boot_soap_example.GetUserResponse;
import com.techprimes.springbootsoapexample.service.UserService;

@Endpoint
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@PayloadRoot(namespace = "http://www.example.org/spring-boot-soap-example", localPart = "getUserRequest")
	@ResponsePayload
	public GetUserResponse getUserRequest(@RequestPayload GetUserRequest getUserRequest) {
		GetUserResponse response = new GetUserResponse();
		response.setUser(userService.getUsers(getUserRequest.getName()));
		return response;

	}
}
