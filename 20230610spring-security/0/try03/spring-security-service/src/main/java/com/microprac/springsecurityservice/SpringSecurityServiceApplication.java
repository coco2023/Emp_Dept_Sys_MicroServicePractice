package com.microprac.springsecurityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

// https://spring.io/guides/gs/securing-web/
@SpringBootApplication()

public class SpringSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityServiceApplication.class, args);
	}

}
