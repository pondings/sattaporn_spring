package com.sattaporn.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sattaporn.dto.CustomerDTO;
import com.sattaporn.model.Customer;
import com.sattaporn.service.CustomerService;

import javassist.bytecode.ByteArray;

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
	
	@RequestMapping(path = "uploadDocument" , method = RequestMethod.POST)
	public ResponseEntity<?> updateDocument(@RequestParam("file") MultipartFile file,@RequestParam(required=true,name="code") String code) {
		System.out.println("[PONDINGS] will upload document " + code);
		
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setSearchKeyword(code);
		customerDTO.setFindMethod("code");
		customerDTO.toUppercase();
		
		Customer customer = customerService.findCustomer(customerDTO).get(0);
		
		try {
			customer.setDocument1(file.getBytes());
			customer = customerService.updateCustomer(customer);			
//			FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/src/main/resources/static/document1/" + customer.getCode());
//			out.write(file.getBytes());
//			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@RequestMapping(path = "/downloadDocument/{code}" , method = RequestMethod.GET)
	public ResponseEntity<byte[]> downloadDocument(@PathVariable String code) {
		System.out.println("asd = " + code);
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setSearchKeyword("CUST00001");
		customerDTO.setFindMethod("code");
		customerDTO.toUppercase();
		Customer targetCustomer = customerService.findCustomer(customerDTO).get(0);

		return new ResponseEntity<byte[]>(targetCustomer.getDocument1(),HttpStatus.OK);
	}
	
}
