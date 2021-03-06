package com.sattaporn.identity;

import org.springframework.security.core.authority.AuthorityUtils;

import com.sattaporn.model.User;

public class TokenUser extends org.springframework.security.core.userdetails.User {

	private User user;

	// For returning a normal user
	public TokenUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList("USER"));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public String getRole() {
		return "USER";
	}
}
