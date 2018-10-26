package com.ambow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class EdurpApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdurpApplication.class, args);
	}
}