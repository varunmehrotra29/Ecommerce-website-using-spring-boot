package com.springboot.login.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.springboot.login.entity.User;
import com.springboot.login.repository.UserImplementation;

@Controller
public class UserController {

	@Autowired
	private UserImplementation user;

	@GetMapping("/loginuser")
	@PostMapping("/loginuser")
	public String login(Model model, String email, String password) {
		String msg = "";
		try {
			Map<User, String> map = user.login(email, password);
			Set<User> set = map.keySet();
			for (User user : set) {
				msg = map.get(user);
				System.out.println(user);
				if (user != null) {
					System.out.println("admin check");
					if (user.getUserType().equals("admin")) {
						return "redirect:/admin";
					}else {
						if(user.getStatus().equals("deactive") ) {

							// activating user comparing dates
							if(LocalDate.now().compareTo(user.getDate())>=0 ) {
								this.user.activateUser(user.getId());
								
							}
							else {
								msg="User Status Deactived !! Login on date : "+user.getDate();
								model.addAttribute("message", msg);
								return "login";
							}
						}
					}
					return "redirect:/home";
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		model.addAttribute("message", msg);

		return "login";
	}

	@GetMapping(value = { "/", "/home" })
	@PostMapping("/home")
	public String home(Model model) {
		return "welcom";
	}

	@GetMapping("/admin")
	public String usersDetails(Model model) {
		List<User> users = user.getUsers();
		model.addAttribute("users", users);
		return "user";
	}

	@GetMapping("/register")
	@PostMapping(value = "/register")
	public String register() {
		return "signup";
	}

	@GetMapping("/signup")
	@PostMapping(value = "/signup")
	public String signup(String mobile, User u1, Model model) {
		u1.setMobileNumber(mobile);
		u1.setUserType("user");
		u1.setDate(LocalDate.now());
		u1.setStatus("active");
		user.register(u1);
		model.addAttribute("message", "Registered successfully !! ");
		return "redirect:/loginuser";
	}

	
	
	@GetMapping("/users")
	@ResponseBody
	public List<User> getAll() {
		return user.getUsers();
	}
	
	

	@GetMapping("/users/{id}")
	@ResponseBody
	public User get(@PathVariable int id) {
		return user.getUser(id);
	}
	
	//delete user by id
	
	@GetMapping("/delete/{id}")
	@PostMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		user.delete(id);
		return "redirect:/admin";
	}
	
	// Deleting all users
	
	@GetMapping("/delete")
	public String deleteAll() {
		user.deleteUsers();
		return "redirect:/admin";
	}

	// deactivating user

	@GetMapping("/block/{id}")
	@PostMapping(value = "/block/{id}")
	public String updateUserStatus(@PathVariable int id) {
		user.updateStatus("deactive", id);
		return "redirect:/admin";
	}

	// activate user

	@GetMapping("/unblock/{id}")
	@PostMapping(value = "/unblock/{id}")
	public String unblockUser(@PathVariable int id) {
		user.updateStatus("active", id);
		return "redirect:/admin";
	}

}
