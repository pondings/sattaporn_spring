package com.sattaporn.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.dto.PermissionAccessDTO;
import com.sattaporn.model.User;
import com.sattaporn.repository.UserRepository;
import com.sattaporn.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUser(int id) {
		// TODO Auto-generated method stub

	}

	public PermissionAccessDTO checkPermission(PermissionAccessDTO permissionAccessDTO) {
		String query = "SELECT mn.code menucode, u.id userid, mp.name permission, mn.name menuname FROM sattaporn.public.user u ";
		query += "JOIN role ro ON u.id = ro.user_id ";
		query += "JOIN permission per ON ro.code = per.code ";
		query += "JOIN menu_permission mp ON per.menu_permission_code = mp.code ";
		query += "JOIN menu mn ON mp.menu_code = mn.code ";
		query += "WHERE u.id = " + permissionAccessDTO.getUserId() + " ";
		query += "AND mn.name = '" + permissionAccessDTO.getMenuName() + "'";
		PermissionAccessDTO permissionDTOList = (PermissionAccessDTO) entityManager.createNativeQuery(query, "permissionDTO").getSingleResult();
		System.out.println(permissionDTOList.toString());
		return permissionDTOList;
	}

}
