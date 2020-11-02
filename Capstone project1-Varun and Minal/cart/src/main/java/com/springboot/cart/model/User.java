package com.springboot.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "cartid")
	private int cartid;

	public int getId() {
		return id;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(int id, String email, String password, int cartid) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.cartid = cartid;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", cartid=" + cartid + "]";
	}
	
	

}
