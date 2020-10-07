package com.Varun.Bigbasketcatlog.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;



@RestController
@RequestMapping("/catlog")
public class CatlogResource {
	
	
	@Autowired
	private RestTemplate restTemplate;
	//@Autowired
	//private WebClient.Builder webClientBuilder;
	
	@RequestMapping("/all")
	public List<Catlog> getallcatlog() {
		
		
	  //this below line is used for getting all the services of DataRating service
		UserRating ratings=restTemplate.getForObject("http://localhost:8083/rating/all",UserRating.class);
		
		
		//this class is maped with the CartInfo service
		return ratings.getUserrating().stream().map(rating->{
			CartInfo cartinfo=restTemplate.getForObject("http://localhost:8082/cart/all",CartInfo.class);
		      return new Catlog(cartinfo.getId(),cartinfo.getGrocerryitems(),"Grocerry",rating.getRating(),cartinfo.getCost(),"Fruits");})
				.collect(Collectors.toList());
		
}
}
