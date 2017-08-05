package com.sattaporn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Customer;
import com.sattaporn.repository.CustomerRepository;
import com.sattaporn.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository ;

	@Override
	public Customer createCustomer(Customer customer) {
		Customer createdCustomer = customerRepository.save(customer);
		return createdCustomer;
	}

	@Override
	public List<Customer> findCustomer(Customer customer) {
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		return customerList;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	@Override
	public void removeCustomer(int id) {
		customerRepository.delete(id);
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = (List<Customer>) customerRepository.findAll();
		return customerList;
	}
	
}
