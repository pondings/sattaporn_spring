package com.sattaporn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.model.User;
import com.sattaporn.service.UserService;

@RestController
@RequestMapping("user")
public class UserRestcontroller {

	@Autowired
	UserService userService;
	
	@RequestMapping(path="create",method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return createdUser;
	}
	
	@RequestMapping(path="find",method=RequestMethod.POST)
	public List<User> findUser(@RequestBody User user) {
		List<User> userList = userService.findUser(user);
		return userList;
	}
	
	@RequestMapping(path="update",method=RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		User updatedUser = userService.updateUser(user);
		return updatedUser;
	}
	
	@RequestMapping(path="remove/{id}",method=RequestMethod.DELETE)
	public void removeUser(@PathVariable int id) {
		userService.removeUser(id);
	}
 	
}
