package com.sattaporn.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
	
	private String id ;
	private String password = "";
	private String name;
	private String lname;
	private String email;
	private String address;
	private String phone;
	private String role;
	
	private boolean isActive;
	private boolean isBlocked;
	
	public enum Role {USER,ADMIN};
	
	public User() {}

	public User(String id, String password, String name, String lname, String email, String address, String phone,
			boolean isActive, boolean isBlocked, String role) {
		super();
		this.id = id;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.name = name;
		this.lname = lname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.isActive = isActive;
		this.isBlocked = isBlocked;
		this.role = role;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
