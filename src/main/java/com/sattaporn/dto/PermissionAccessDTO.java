package com.sattaporn.dto;

public class PermissionAccessDTO {

	private int id;
	private int userId;
	private String permission;
	private String menuName;
	
	public PermissionAccessDTO(int id, int userId, String permission, String menuName) {
		this.id = id;
		this.userId = userId;
		this.permission = permission;
		this.menuName = menuName;
	}
	
	
	
	public PermissionAccessDTO() {
		super();
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
}
