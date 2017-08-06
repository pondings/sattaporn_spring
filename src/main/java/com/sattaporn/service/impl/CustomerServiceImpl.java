package com.sattaporn.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.dto.CustomerDTO;
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
		customer.setFullName(customer.getSirName() + " " + customer.getName() + " " + customer.getLname());
		Customer createdCustomer = customerRepository.save(customer);
		createdCustomer.setCode("CUST"+String.format("%05d", customer.getId()));
		createdCustomer.setCreateDate(new Date());
		createdCustomer.setCreateBy("Sattaporn Klaiamorn");
		Customer updatedCustomerCode = customerRepository.save(createdCustomer);
		return updatedCustomerCode;
	}

	@Override
	public List<Customer> findCustomer(CustomerDTO customer) {
		String findingMethod = customer.getFindMethod();
		customer.toUppercase();
		List<Customer> customerList = new ArrayList<>();
		System.out.println("[PONDINGS] searchMethod = " + customer.getFindMethod());
		System.out.println("[PONDINGS] searchKeyword = " + customer.getSearchKeyword() == null ? "null" : "not null");
		switch (findingMethod) {
		case "fullName":
			customerList = customerRepository.findCustomerByName(customer);
			break;
		case "address": 
			System.out.println("The method Find by address not complete");
			break;
		case "workAddress" :
			System.out.println("The method Find by address not complete");
			break;
		case "code":
			customerList = customerRepository.findCustomerByCode(customer);
			break;
		case "phone":
			customerList = customerRepository.findCustomerByPhone(customer);
			break;
		default:
			System.out.println("Something went wrong !");
			break;
		}
		System.out.println("Fetct size = " + customerList.size());
		return customerList;
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		customer.setFullName(customer.getSirName() + " " + customer.getName() + " " + customer.getLname());
		customer.setUpdateDate(new Date());
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
