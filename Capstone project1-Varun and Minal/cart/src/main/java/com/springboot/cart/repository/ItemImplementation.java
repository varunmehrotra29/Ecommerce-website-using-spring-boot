package com.springboot.cart.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.cart.model.Item;

@Service
@Transactional
public class ItemImplementation {

	@Autowired
	private ItemDao itemdao;
	
	
	public List<Item> findItems(){
		return itemdao.findAll();
	}
	
	public Item getItem(int id) {
		return itemdao.getOne(id);
	}
	
}
