package com.mtoliv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootMybatisplusShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMybatisplusShiroApplication.class, args);
	}
}