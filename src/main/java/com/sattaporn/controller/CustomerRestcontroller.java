package com.sattaporn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.model.Customer;
import com.sattaporn.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerRestcontroller {

	@Autowired
	CustomerService customerService ;
	
	@RequestMapping(path = "/showAll" , method = RequestMethod.GET)
	public void showAll(){
		System.out.println("[PONDINGS] Show all method work !");
	}
	
	@RequestMapping(path = "/create" , method = RequestMethod.POST)
	public Customer createCustomer(){
		System.out.println("[PONDINGS] Start method createCustomer");
		return null;
	}
	
	@RequestMapping(path = "/update" , method = RequestMethod.PUT)
	public Customer updateCustomer(){
		System.out.println("[PONDINGS] Start method updateCustomer");
		return null;
	}
	
	@RequestMapping(path = "/remove" , method = RequestMethod.DELETE)
	public Customer removeCustomer(){
		System.out.println("[PONDINGS] Start method removeCustomer");
		return null;
	}
	
	@RequestMapping(path = "/find" , method = RequestMethod.POST)
	public Customer findCustomer(){
		System.out.println("[PONDINGS] Start method findCustomer");
		return null;
	}
	
	
}
