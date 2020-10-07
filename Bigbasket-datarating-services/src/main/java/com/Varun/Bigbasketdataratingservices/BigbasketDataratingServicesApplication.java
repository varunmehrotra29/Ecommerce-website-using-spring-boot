package com.Varun.Bigbasketdataratingservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BigbasketDataratingServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigbasketDataratingServicesApplication.class, args);
	}

}
