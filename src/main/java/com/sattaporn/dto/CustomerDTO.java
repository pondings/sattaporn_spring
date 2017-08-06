package com.sattaporn.dto;

import com.sattaporn.model.Customer;

public class CustomerDTO extends Customer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String findMethod;
	private String searchKeyword;
	
	public String getFindMethod() {
		return findMethod;
	}
	
	public void setFindMethod(String findMethod) {
		this.findMethod = findMethod;
	}
	
	public String getSearchKeyword() {
		return searchKeyword;
	}
	
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	@Override
	public String toString() {
		return "CustomerDTO [findMethod=" + findMethod + ", searchKeyword=" + searchKeyword + "]";
	}
	
	
	public void toUppercase() {
		searchKeyword = searchKeyword != null ? searchKeyword.toUpperCase() : "";
	}
	
	
}
