package com.springboot.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cart.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer>{
	
	@Query(value = "select * from cart where userid = ?1 ;", nativeQuery = true)
	public Cart getCart(int userid);
	
	@Modifying
	@Query(value = "update cart set totalcost = ?1  where id = ?2 ;", nativeQuery = true)
	public void updateCost(double totalcost,int id);

}
