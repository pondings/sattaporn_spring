package com.sattaporn.service;

import java.util.List;

import com.sattaporn.model.Service;

public interface APIService {

	public List<Service> findAll() ;
	
	public List<Service> findByName(String serviceName);
	
}
