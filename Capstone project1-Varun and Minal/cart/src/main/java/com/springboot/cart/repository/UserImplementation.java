package com.springboot.cart.repository;




import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.cart.model.User;

@Service
@Transactional
public class UserImplementation{

	@Autowired
	private UserDao userdao;
	
	
	//find user by email
		public User findUser(String email) {
			return userdao.findUserByEmail(email);
		}


	
}
