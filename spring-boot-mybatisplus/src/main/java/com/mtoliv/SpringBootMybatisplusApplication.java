package com.mtoliv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootMybatisplusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisplusApplication.class, args);
	}
}