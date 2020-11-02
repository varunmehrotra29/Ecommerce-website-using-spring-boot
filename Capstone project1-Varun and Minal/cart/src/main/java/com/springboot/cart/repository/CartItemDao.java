package com.springboot.cart.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cart.model.CartItem;

public interface CartItemDao  extends JpaRepository<CartItem, Integer>{
	
	@Modifying
	@Query(value = "update cart_item set quantity = ?1  where id = ?2 ;", nativeQuery = true)
	public void updateQuantity(int quantity,int id);


}
