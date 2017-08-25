package com.sattaporn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.dto.Login;
import com.sattaporn.dto.OperationResponse.ResponseStatusEnum;
import com.sattaporn.dto.PermissionAccessDTO;
import com.sattaporn.dto.SessionItem;
import com.sattaporn.dto.response.SessionResponse;
import com.sattaporn.model.User;
import com.sattaporn.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("auth")
@Api(tags = {"Authentication"})
public class AuthenicationRestcontroller {

	@Autowired
	UserRepository userRepository;
	
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = SessionResponse.class) })
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public SessionResponse login(@RequestBody Login login,HttpServletRequest request, HttpServletResponse response) {
		User user = userRepository.findUserByUsername(login.getUsername());
		SessionResponse sessionResponse = new SessionResponse();
		SessionItem sessionItem = new SessionItem();
		if(user != null) {
			sessionItem.setToken("xxxx.xxxx.xxxx");
			sessionItem.setEmail(user.getEmployee().getEmail());
			sessionItem.setFullName(user.getEmployee().getFullName());
			sessionItem.setId(String.valueOf(user.getId()));
			
			sessionResponse.setItem(sessionItem);
			sessionResponse.setOperationMessage("LOGGIN SUCCESS");
			sessionResponse.setOperationStatus(ResponseStatusEnum.SUCCESS);
		}else {
			sessionResponse.setOperationMessage("LOGGIN FAIL");
			sessionResponse.setOperationStatus(ResponseStatusEnum.ERROR);
		}
		
		return sessionResponse;
		
	}
	
	@RequestMapping(value="permission", method=RequestMethod.POST)
	public PermissionAccessDTO test(@RequestBody PermissionAccessDTO permissionAccessDTO) {
		permissionAccessDTO.setMenuName(permissionAccessDTO.getMenuName().replace("/", ""));
		PermissionAccessDTO permission = new PermissionAccessDTO();
		System.out.println("i will find ! " + permissionAccessDTO.getMenuName());
		try {
			permission = userRepository.checkPermission(permissionAccessDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return permission;
	}

	
}
