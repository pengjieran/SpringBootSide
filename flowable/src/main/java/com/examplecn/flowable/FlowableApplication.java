package com.examplecn.flowable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//处理无SecurityAutoConfiguration异常
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
public class FlowableApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowableApplication.class, args);
	}

}