package com.springboot.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.cart.model.Item;

@Repository
public interface ItemDao extends JpaRepository<Item, Integer>{

}
