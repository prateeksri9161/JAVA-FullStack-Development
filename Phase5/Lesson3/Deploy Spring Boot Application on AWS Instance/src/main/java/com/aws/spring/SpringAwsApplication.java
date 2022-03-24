package com.aws.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringAwsApplication {
	@GetMapping("/")
	public String home() {
		return "Welcome to AWS Application Deployment By Prateek Srivastava";
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringAwsApplication.class, args);
	}

}
