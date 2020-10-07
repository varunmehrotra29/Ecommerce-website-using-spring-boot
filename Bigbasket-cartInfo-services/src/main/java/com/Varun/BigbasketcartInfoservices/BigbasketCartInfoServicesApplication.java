package com.Varun.BigbasketcartInfoservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BigbasketCartInfoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigbasketCartInfoServicesApplication.class, args);
	}

}
