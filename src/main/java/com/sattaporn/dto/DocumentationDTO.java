package com.sattaporn.dto;

import com.sattaporn.model.Documentation;

public class DocumentationDTO extends Documentation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public DocumentationDTO() {
		super();
	}
	
	public DocumentationDTO(String findMethod, String searchKeyword) {
		super();
		this.findMethod = findMethod;
		this.searchKeyword = searchKeyword;
	}
	
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
	
	
	
}
