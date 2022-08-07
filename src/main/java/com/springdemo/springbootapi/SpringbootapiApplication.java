package com.springdemo.springbootapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootapiApplication {
	// Postman Client <-> Controller <-> Service <-> DAO <-> DB
	public static void main(String[] args) {
		SpringApplication.run(SpringbootapiApplication.class, args);
//		Run Commands:
//		mvnspring-boot:run
//		mvn clean install
//		cd target
//		dir
//		java -jar springbootapi-1.0.0.jar --spring.profiles.active=prod
	}

}
