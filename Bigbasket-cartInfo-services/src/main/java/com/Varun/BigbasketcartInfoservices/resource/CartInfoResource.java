package com.Varun.BigbasketcartInfoservices.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/cart")
public class CartInfoResource {
	@Autowired
	CartRepository cartrepository;
	
	@GetMapping("/all")
	public CartInformation getAll(){
		
		List<CartInfo> cartinfo= cartrepository.findAll();
		CartInformation cartinformation=new CartInformation();
		cartinformation.setCartinformation(cartinfo);
		return cartinformation;
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/new")
	public List<CartInfo> persist(@RequestBody final  CartInfo cartinfo){
		cartrepository.save(cartinfo);
		return cartrepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.PUT,value="/update")
	public void updateCart(@RequestBody CartInfo cartinfo) {
		cartrepository.save(cartinfo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/del")
	public void delete(@RequestBody CartInfo cartinfo)
	{
		  cartrepository.delete(cartinfo);
	}
	

}
