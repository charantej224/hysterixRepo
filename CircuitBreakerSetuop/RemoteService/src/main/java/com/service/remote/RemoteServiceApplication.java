package com.service.remote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.service")
public class RemoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteServiceApplication.class, args);
	}
}
