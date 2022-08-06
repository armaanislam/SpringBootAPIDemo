package com.springdemo.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootapiApplication {
	// Postman Client <-> Controller <-> Service <-> DAO <-> DB
	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
	}

}
