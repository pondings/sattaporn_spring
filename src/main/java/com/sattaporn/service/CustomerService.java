package com.sattaporn.service;

import java.util.List;

import com.sattaporn.dto.CustomerDTO;
import com.sattaporn.model.Customer;

public interface CustomerService {

	public List<Customer> findAll();
	
	public Customer createCustomer(Customer customer);
	
	public List<Customer> findCustomer(CustomerDTO customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void removeCustomer(int id);
	
}
