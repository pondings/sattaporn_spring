package com.sattaporn.dto;

public class PermissionAccessDTO {

	private String menuCode;
	private int userId;
	private String permission;
	private String menuName;

	public PermissionAccessDTO(String menuCode, int userId, String permission, String menuName) {
		this.menuCode = menuCode;
		this.userId = userId;
		this.permission = permission;
		this.menuName = menuName;
	}

	public PermissionAccessDTO() {

	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
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

	@Override
	public String toString() {
		return "PermissionAccessDTO [menuCode=" + menuCode + ", userId=" + userId + ", permission=" + permission
				+ ", menuName=" + menuName + "]";
	}
	
	

}
