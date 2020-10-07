package comVarun.Bigbasketcatlogservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class BigbasketCatlogServicesApplication {
	
	
	@Bean
	@LoadBalanced
	public RestTemplate getAllTemplates() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(BigbasketCatlogServicesApplication.class, args);
	}

}
