package com.springboot.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.cart.model.User;

public interface UserDao extends JpaRepository<User, Integer> {
	
	@Query(value = "select * from user where email = ?1 ;", nativeQuery = true)
	public User findUserByEmail(String email);
}
