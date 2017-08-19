package com.sattaporn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.model.Service;
import com.sattaporn.service.APIService;

@RestController
@RequestMapping("api")
public class APIRestcontroller {

	@Autowired
	APIService apiService ;
	
	@RequestMapping(path="/findAll",method=RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Service> serviceList = apiService.findAll();
		return new ResponseEntity<List<Service>>(serviceList,HttpStatus.OK);
	}
	
	@RequestMapping(path="/findByName",method=RequestMethod.POST)
	public ResponseEntity<?> findByName(@RequestBody Service service) {
		List<Service> serviceList = apiService.findAll();
		return new ResponseEntity<List<Service>>(serviceList,HttpStatus.OK);
	}
	
	
}
