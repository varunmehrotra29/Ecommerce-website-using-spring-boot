package com.Varun.BigbasketcartInfoservices.resource;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartInfo,Integer> {

}
