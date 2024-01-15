package com.Manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //used to enable the Swagger2 for your Spring Boot application.
public class ManagerEndUser2Application {

	public static void main(String[] args) {
		SpringApplication.run(ManagerEndUser2Application.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.Room.Controller"))
				.apis(RequestHandlerSelectors.basePackage("com.Inventary.Controller"))
				.apis(RequestHandlerSelectors.basePackage("com.Staff.Controller"))
				
				.build();

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	return new WebMvcConfigurer() {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**").allowedOrigins("http://localhost:3000");
	}
	};
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
