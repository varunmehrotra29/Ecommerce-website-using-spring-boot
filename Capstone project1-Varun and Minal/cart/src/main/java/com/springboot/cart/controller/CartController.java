package com.springboot.cart.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.springboot.cart.model.Cart;
import com.springboot.cart.model.CartItem;
import com.springboot.cart.model.Item;
import com.springboot.cart.model.User;
import com.springboot.cart.repository.CartDao;
import com.springboot.cart.repository.CartItemDao;
import com.springboot.cart.repository.ItemImplementation;
import com.springboot.cart.repository.UserImplementation;


@Controller
@Transactional
public class CartController {

	@Autowired
	private ItemImplementation itemimp;

	@Autowired
	private UserImplementation userimp;

	@Autowired
	private CartDao cartdao;

	@Autowired
	private CartItemDao cartitemdao;
	
	@Autowired
	private RestTemplate restTemplate;
	
	//list of catlog
	
	@RequestMapping("/catlog")
	public List<User> getallcatlog() {
		CartInformation ratings=restTemplate.getForObject("http://ECOMMERCE-LOGIN-SERVICE/all",CartInformation.class);
		
		return ratings.getCartinformation().stream().map(rating->{
			return new User(rating.getId(),rating.getEmail(),rating.getPassword(),1);}).collect(Collectors.toList());	
		
		
	}
	
	// list of products

	@RequestMapping("/products")
	public List<Item> products() {
		List<Item> items = itemimp.findItems();
		return items;
	}
	

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:http://localhost:8087/loginuser";
	}

	//user login
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public List<Item> login(@RequestBody User u, HttpSession session) {
		User user = userimp.findUser(u.getEmail());
		if (user.getPassword().equals(u.getPassword())) {
			session.setAttribute("id", user.getId());
			return itemimp.findItems();
		}

		return null;
	}

	// cart items
	
	@RequestMapping("/cart")
	public Cart cart( HttpSession session) {
		int userid = (Integer) session.getAttribute("id");
		Cart cart = cartdao.getCart(userid);
		System.out.println(cart);
		return cart;
	}
	
	
	// add items to cart

	@RequestMapping("cart/{id}")
	public Cart cart(@PathVariable int id, HttpSession session) {
		int userid = (int) session.getAttribute("id");
		Cart cart = cartdao.getCart(userid);
		Item item = itemimp.getItem(id);
		CartItem cartitem = new CartItem(item, 1, cart);
		cartitemdao.save(cartitem);
		double totalcost = totalCost(session);
		cartdao.updateCost(totalcost, cart.getId());
		return cart;
	}
	
	
	// update item quantity

	@RequestMapping(value = "cart/", method = RequestMethod.PUT)
	public Cart updateCart(@RequestBody CartItem cartitem, HttpSession session) {
		int userid = (Integer) session.getAttribute("id");
		Cart cart = cartdao.getCart(userid);
		if (cartitem.getQuantity() <= 0) {
			cartitemdao.delete(cartitem);
			double totalcost = totalCost(session);
			cartdao.updateCost(totalcost, cart.getId());
		} else {
			cartitemdao.updateQuantity(cartitem.getQuantity(), cartitem.getId());
			double totalcost = totalCost(session);
			cartdao.updateCost(totalcost, cart.getId());
		}
		return cart;
	}
	
	// delete item from cart

	@RequestMapping(value="/cart" , method = RequestMethod.DELETE)
	public Cart deleteItem (@RequestBody CartItem cartitem,HttpSession session) {
		int userid = (Integer) session.getAttribute("id");
		Cart cart = cartdao.getCart(userid);
		cartitemdao.delete(cartitem);
		double totalcost = totalCost(session);
		cartdao.updateCost(totalcost, cart.getId());
		return cart;
	}
	
	// calculating total cost
	
	public double totalCost(HttpSession session) {
		int userid = (int) session.getAttribute("id");
		Cart cart = cartdao.getCart(userid);
		double totalcost=0;
		List<CartItem> items = cart.getItems();
		for (CartItem cartItem : items) {
			totalcost+=cartItem.getQuantity()*cartItem.getItem().getPrice();
		}
		return totalcost;
	}
	
	
}
