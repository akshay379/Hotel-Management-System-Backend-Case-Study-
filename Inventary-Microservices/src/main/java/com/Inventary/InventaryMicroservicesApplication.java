package com.Inventary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//Spring Boot application act as a Eureka client
public class InventaryMicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventaryMicroservicesApplication.class, args);
	}

}
