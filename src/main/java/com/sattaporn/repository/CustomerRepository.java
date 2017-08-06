package com.sattaporn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.dto.CustomerDTO;
import com.sattaporn.model.Customer;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    
	@Query("SELECT cust FROM Customer cust WHERE 1=1 AND (UPPER(cust.fullName) LIKE %:#{#param.searchKeyword != null ? #param.searchKeyword : ''}%)")
    public List<Customer> findCustomerByName(@Param("param") CustomerDTO customer);
	
//	public List<Customer> findCustomerByAddress();
	
//	public List<Customer> findCustomerByWorkAddress();
	
	@Query("SELECT cust FROM Customer cust WHERE 1=1 AND (cust.phone = :#{#param.searchKeyword})")
	public List<Customer> findCustomerByPhone(@Param("param") CustomerDTO customer);
	
	@Query("SELECT cust FROM Customer cust WHERE 1=1 AND (cust.code = :#{#param.searchKeyword})")
	public List<Customer> findCustomerByCode(@Param("param") CustomerDTO customer);
    
}