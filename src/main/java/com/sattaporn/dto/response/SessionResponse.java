package com.sattaporn.dto.response;

import com.sattaporn.dto.OperationResponse;
import com.sattaporn.dto.SessionItem;

public class SessionResponse extends OperationResponse{

	private SessionItem item;

	public SessionItem getItem() {
		return item;
	}

	public void setItem(SessionItem item) {
		this.item = item;
	}
	
	
	
}
