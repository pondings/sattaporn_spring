package com.sattaporn.service;

import java.util.List;

import com.sattaporn.dto.PermissionAccessDTO;
import com.sattaporn.model.User;

public interface UserService {

	public User createUser(User user);
	
	public List<User> findUser(User user);
	
	public User updateUser(User user);
	
	public void removeUser(int id);
	
	public PermissionAccessDTO checkPermission(PermissionAccessDTO permissionAccessDTO);
	
}
