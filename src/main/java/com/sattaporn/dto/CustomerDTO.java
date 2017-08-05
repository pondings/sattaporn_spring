package com.sattaporn.dto;

import com.sattaporn.model.Customer;

public class CustomerDTO extends Customer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String findMethod;
	
	public String getFindMethod() {
		return findMethod;
	}
	public void setFindMethod(String findMethod) {
		this.findMethod = findMethod;
	}
	
	@Override
	public String toString() {
		return "CustomerDTO [findMethod=" + findMethod + "]";
	}
	
	
}
