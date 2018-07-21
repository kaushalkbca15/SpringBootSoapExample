package com.techprimes.springbootsoapexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.techprimes.springbootsoapexample.config,com.techprimes.springbootsoapexample.endpoint,com.techprimes.springbootsoapexample.service,org.example.spring_boot_soap_example")
public class SpringBootSoapExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSoapExampleApplication.class, args);
	}
}
