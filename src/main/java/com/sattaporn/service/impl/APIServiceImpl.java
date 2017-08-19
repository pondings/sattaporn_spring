package com.sattaporn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.repository.APIRepository;
import com.sattaporn.service.APIService;

@Service
@Transactional
public class APIServiceImpl implements APIService{

	@Autowired
	APIRepository apirepository ;
	
	@Override
	public List<com.sattaporn.model.Service> findAll() {
		List<com.sattaporn.model.Service> serviceList = (List<com.sattaporn.model.Service>) apirepository.findAll();
		return serviceList;
	}

	@Override
	public List<com.sattaporn.model.Service> findByName(String serviceName) {
		List<com.sattaporn.model.Service> serviceList = apirepository.findByName(serviceName);
		return serviceList;
	}

}
