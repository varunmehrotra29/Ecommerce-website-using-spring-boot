package com.Varun.BigbasketcartInfoservices.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartInfo {

	
	@Id
	@GeneratedValue
	@Column(name="Id")
	private Integer Id;
	@Column(name="grocerryitems")
	private String grocerryitems;
	@Column(name="cost")
	private String cost;
	
	
	public CartInfo() {
		
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getGrocerryitems() {
		return grocerryitems;
	}
	public void setGrocerryitems(String grocerryitems) {
		this.grocerryitems = grocerryitems;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	
	
	
}
