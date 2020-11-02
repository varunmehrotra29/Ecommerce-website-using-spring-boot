package com.springboot.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Item item;
	
	@Column(name="quantity")
	private int quantity;

	@ManyToOne
	@JsonIgnore
	private Cart cart;

	public CartItem(Item item, int quantity, Cart cart) {
		this.item = item;
		this.quantity = quantity;
		this.cart = cart;
	}
	
	public CartItem(Item item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "CartItem [id=" + id + ", item=" + item + ", quantity=" + quantity + "]";
	}
	
	
	
}
