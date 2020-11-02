package com.springboot.login.controller;

import java.util.List;


import com.springboot.login.entity.Users;



public class CartInformation {
	private List<Users> cartinformation;

	public List<Users> getCartinformation() {
		return cartinformation;
	}

	public void setCartinformation(List<Users> cartinformation) {
		this.cartinformation = cartinformation;
	}
	
}
