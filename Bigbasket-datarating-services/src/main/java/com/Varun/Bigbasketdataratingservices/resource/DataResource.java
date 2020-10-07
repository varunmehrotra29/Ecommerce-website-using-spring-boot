package com.Varun.Bigbasketdataratingservices.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rating")
public class DataResource {
	
	@Autowired
	DataRepository datarepository;
	
	@GetMapping("/all")
	public UserRating getAll(){
		
		List<DataRating> ratings= datarepository.findAll();	
		UserRating userrating=new UserRating();
		userrating.setUserrating(ratings);
		return userrating;
		
	}
	
	/*@RequestMapping("/users")
	public UserRatings listofrating(){
		List<Rating> ratings=Arrays.asList(
	             new Rating(5,"war"),
	             new Rating(4,"venom") );
		UserRatings userrating=new UserRatings();
		userrating.setUserrating(ratings);
		return userrating;
	}*/
	@RequestMapping(method=RequestMethod.POST,value="/new")
	public List<DataRating> persist(@RequestBody final  DataRating datarating){
		datarepository.save(datarating);
		return datarepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/update")
	public void updateCart(@RequestBody DataRating datarating) {
		datarepository.save(datarating);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/del")
	public void delete(@RequestBody DataRating datarating)
	{
		  datarepository.delete(datarating);
	}
	
	

}
