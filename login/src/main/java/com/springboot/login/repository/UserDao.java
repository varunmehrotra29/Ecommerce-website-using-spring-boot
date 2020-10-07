package com.springboot.login.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.login.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{

	
	@Query(value= "select * from users_details where email = ?1 ;", nativeQuery = true)
	public User findUserByEmail(String email);
	
	@Modifying
	@Query(value = "delete from users_details u where u.usertype = ?1 ;",nativeQuery = true)
	public void deleteUsers(String usertype);
	
	@Modifying
	@Query(value = "select * from users_details u where u.usertype = ?1 ;",nativeQuery = true)
	public List<User> findUsers(String usertype);
	
	@Modifying
	@Query(value = "update users_details set status = ?1 , dateactive = ?2 where id = ?3 ;" , nativeQuery = true)
	public void update(String status,LocalDate date ,int id);
	
	@Modifying
	@Query(value = "update users_details set status = ?1 where id = ?2 ;" , nativeQuery = true)
	public void activateAccount(String status,int id);
	
}
