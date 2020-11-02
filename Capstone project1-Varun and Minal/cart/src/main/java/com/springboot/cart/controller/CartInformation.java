package com.springboot.cart.controller;

import java.util.List;


public class CartInformation {
	private List<Users> cartinformation;

	public List<Users> getCartinformation() {
		return cartinformation;
	}

	public void setCartinformation(List<Users> cartinformation) {
		this.cartinformation = cartinformation;
	}
	
}
