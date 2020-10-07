package com.Varun.Bigbasketcatlog.resource;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity
public class Catlog {
	
	@Id
	@GeneratedValue
	@Column(name="Id")
   	private Integer Id;
	@Column(name="grocerryitems")
	private String grocerryitems;
	@Column(name="desc")
	private String desc;
	@Column(name="rating")
	private String rating;
	@Column(name="cost")
	private String cost;
	@Column(name="category")
	private String category;
	

	public Catlog(Integer id, String grocerryitems, String desc, String rating, String cost, String category) {
		super();
		Id = id;
		this.grocerryitems = grocerryitems;
		this.desc = desc;
		this.rating = rating;
		this.cost = cost;
		this.category = category;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

}
