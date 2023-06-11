package com.microprac.springsecurityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class SpringSecurityServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityServiceApplication.class, args);
	}

}
