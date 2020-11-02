package com.springboot.cart.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart {
		
	   @Id
		private int id;
		
		@OneToMany(mappedBy = "cart")
		private List<CartItem> cartItems;
		
		@Column(name="userid")
		private int userid;
		
		@Column(name="totalcost")
		private double totalCost;
		
		public Cart() {
		}

		public Cart(int id, List<CartItem> cartItems) {
			this.id = id;
			this.cartItems = cartItems;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public List<CartItem> getItems() {
			return cartItems;
		}

		public void setItems(List<CartItem> cartItems) {
			this.cartItems = cartItems;
		}
		
		
		@Override
		public String toString() {
			return "Cart [id=" + id + "totalcost=" + totalCost + "]";
		}
		

}
