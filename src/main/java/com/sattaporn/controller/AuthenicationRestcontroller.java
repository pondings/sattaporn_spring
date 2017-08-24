package com.sattaporn.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.dto.Login;
import com.sattaporn.dto.OperationResponse.ResponseStatusEnum;
import com.sattaporn.dto.SessionItem;
import com.sattaporn.dto.response.SessionResponse;
import com.sattaporn.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("auth")
@Api(tags = {"Authentication"})
public class AuthenicationRestcontroller {

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Will return a security token, which must be passed in every request", response = SessionResponse.class) })
	@RequestMapping(value="login", method=RequestMethod.POST)
	@ResponseBody
	public SessionResponse login(@RequestBody Login login,HttpServletRequest request, HttpServletResponse response) {
		User user = checkUser(login);
		SessionResponse sessionResponse = new SessionResponse();
		SessionItem sessionItem = new SessionItem();
		if(user != null) {
			sessionItem.setToken("xxxx.xxxx.xxxx");
			sessionItem.setEmail(user.getEmail());
			sessionItem.setFirstName(user.getName());
			sessionItem.setLastName(user.getLname());
			sessionItem.setId("1");
			
			sessionResponse.setItem(sessionItem);
			sessionResponse.setOperationMessage("LOGGIN SUCCESS");
			sessionResponse.setOperationStatus(ResponseStatusEnum.SUCCESS);
		}else {
			sessionResponse.setOperationMessage("LOGGIN FAIL");
			sessionResponse.setOperationStatus(ResponseStatusEnum.ERROR);
		}
		
		return sessionResponse;
		
	}
	
	private User checkUser(Login login) {
		User user = null;
		String username = login.getUsername();
		String password = login.getPassword();
		
		if (username.equals("pondings") && password.equals("papapapond")) {
			user = new User();
			user.setName("Pawarut");
			user.setLname("Klai-armon");
			user.setEmail("pawarut.klaiarmon@gmail.com");
			user.setBlocked(false);
			user.setActive(true);
			user.setId("1");
		}
		
		return user;
		
	}
	
}
