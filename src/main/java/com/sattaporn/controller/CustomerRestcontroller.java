package com.sattaporn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sattaporn.dto.CustomerDTO;
import com.sattaporn.model.Customer;
import com.sattaporn.service.CustomerService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("customer")
public class CustomerRestcontroller {

	@Autowired
	CustomerService customerService ;
	
	@RequestMapping(path = "/showAll" , method = RequestMethod.GET)
	public ResponseEntity<?> showAll(){
		System.out.println("[PONDINGS] Show all method work !");
		List<Customer> customerList = customerService.findAll();
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create" , method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		System.out.println("[PONDINGS] Start method createCustomer");
		Customer createdCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(createdCustomer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/update" , method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		System.out.println("[PONDINGS] Start method updateCustomer");
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
//	@CrossOrigin("http://localhost:4200")
	@RequestMapping(path = "/remove/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<?> removeCustomer(@PathVariable int id){
		System.out.println("[PONDINGS] Start method removeCustomer");
		try {
			customerService.removeCustomer(id);
			return new ResponseEntity<String>("Remove Customer " + id , HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("[PONDNGS] Error on remove method.");
			return new ResponseEntity<String>("Cant remove customer id " + id , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/find" , method = RequestMethod.POST)
	public ResponseEntity<List<Customer>> findCustomer(@RequestBody CustomerDTO customer){
		System.out.println("[PONDINGS] Start method findCustomer");
		List<Customer> customerList = customerService.findCustomer(customer);
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}
	
	
}
