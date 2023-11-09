package com.example.demospringJWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.example.demospringJWT.jwtutils.TokenManager")
public class DemoSpringJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJwtApplication.class, args);
	}

}
