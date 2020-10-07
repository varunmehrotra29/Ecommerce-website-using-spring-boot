package com.springboot.login.repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.login.entity.User;

@Service
@Transactional
public class UserImplementation {
	
	@Autowired
	private UserDao user;
	

	public void register(User u) {
		user.save(u);
	}
	
	public List<User> getUsers(){
		return user.findUsers("user");
	}
	
	public User getUser(int id) {
		return user.getOne(id);
	}
	
	
	public Map<User, String> login(String email,String password) {
		Map<User,String> map= new HashMap<User,String>();
		String msg="";
		try {
			User u= user.findUserByEmail(email);
			if(u!=null) {
				boolean passwordCheck = u.getPassword().equalsIgnoreCase(password);
				if(passwordCheck) {
					map.put(u, msg);
				}else {
					msg="Enter password is incorrect!!!";
					map.put(null, msg);
				}
				
			}else {
				msg="User Does not exists";
				map.put(null, msg);
			}
		}catch (Exception e) {
			msg="User Does not exists";
			map.put(null, msg);
		}
		return map;
	}

	public void delete(int id) {
		user.deleteById(id);
	}
	
	public void deleteUsers() {
		user.deleteUsers("user");
	}
	
	//deactivating user for time span 7 days
	
	public void updateStatus(int id) {
		LocalDate date = LocalDate.now().plusDays(7);
		user.update("deactive", date, id);
	}
	
	// activating user
	
	public void activateUser(int id) {
		user.activateAccount("active",id);
	}
	
}
