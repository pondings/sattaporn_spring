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

@CrossOrigin
@RestController
@RequestMapping("customer")
public class CustomerRestcontroller {

	@Autowired
	CustomerService customerService ;

	
	@RequestMapping(path = "/showAll" , method = RequestMethod.GET)
	public ResponseEntity<?> showAll(){
		List<Customer> customerList = customerService.findAll();
		return new ResponseEntity<List<Customer>>(customerList, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/create" , method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer){
		Customer createdCustomer = customerService.createCustomer(customer);
		return new ResponseEntity<Customer>(createdCustomer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/update" , method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = customerService.updateCustomer(customer);
		return new ResponseEntity<Customer>(updatedCustomer,HttpStatus.OK);
	}
	
	@RequestMapping(path = "/remove/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<?> removeCustomer(@PathVariable int id){
		System.out.println("id = " + id);
		try {			
			customerService.removeCustomer(id);
			return new ResponseEntity<String>("Remove Customer ", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Cant remove customer id " , HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(path = "/find" , method = RequestMethod.POST)
	public ResponseEntity<List<Customer>> findCustomer(@RequestBody CustomerDTO customer){
		List<Customer> customerList = customerService.findCustomer(customer);
		return new ResponseEntity<List<Customer>>(customerList,HttpStatus.OK);
	}
	
	
}
