package com.ordering.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ordering.dao.UserDao;
import com.ordering.model.User;
import com.ordering.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	private UserDao userDao;
	
	@RequestMapping("/")
	public String setupForm(Map<String, Object> map){
		User user = new User();
		map.put("user", user);
		map.put("userList", userService.getAllUser());
		return "login";
	}
	
	@RequestMapping(value ="/login", method=RequestMethod.POST)
	public String userLogin(@ModelAttribute User user, @RequestParam String username, String password, Map<String, Object> map)
	{
		System.out.print(username);
		
		User usr = this.userDao.getUser(username);
		String uname = usr.getUsername();
		String passwd = usr.getPassword();
		
		if(uname != username){
			return "user";
		}
		else if(passwd != password){
			return "login";
		}
		else{
			return "menu";
		}
	}
	
	
	@RequestMapping(value="/addUser", method=RequestMethod.POST)
	public String doActions(@ModelAttribute User user, BindingResult result, @RequestParam String action, Map<String, Object> map){
		User userResult = new User();
		switch(action.toLowerCase()){	//only in Java7 you can put String in switch
		case "add":
			userService.add(user);
			userResult = user;
			break;
		case "edit":
			userService.edit(user);
			userResult = user;
			break;
//		case "delete":
//			userService.delete(user.getUserId());
//			userResult = new User();
//			break;
//		case "search":
//			User searchedUser = userService.getUser(user.getUserId());
//			userResult = searchedUser!=null ? searchedUser : new User();
//			break;
		}
		map.put("user", userResult);
		map.put("userList", userService.getAllUser());
		map.put("minombre", "Jose");
		
		return "user";
	}
}
