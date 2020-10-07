package com.Varun.Bigbasketcatlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@SpringBootApplication
public class BigbasketCatlogApplication {

	
	@Bean
	public RestTemplate getAllTemplates() {
		return new RestTemplate();
	}
	@Bean
	public Builder getWebClientBuilder() {
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(BigbasketCatlogApplication.class, args);
	}

}
