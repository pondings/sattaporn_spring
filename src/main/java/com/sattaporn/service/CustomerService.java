package com.sattaporn.service;

import java.util.List;

import com.sattaporn.model.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public List<Customer> findCustomer(Customer customer);
	
	public Customer updateCustomer(Customer customer);
	
	public void removeCustomer(int id);
	
}
