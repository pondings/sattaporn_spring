package com.sattaporn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Customer;;

@Repository
@Transactional(readOnly = true)
public interface CustomerRepository extends CrudRepository<Customer, Integer>{
    
	@Query("SELECT cust FROM Customer cust WHERE 1=1 AND (UPPER(cust.fullName) LIKE %:#{#param.fullName != null ? #param.fullName : ''}%)")
    public List<Customer> findCustomerByName(@Param("param") Customer customer);
	
//	public List<Customer> findCustomerByAddress();
	
//	public List<Customer> findCustomerByWorkAddress();
	
//	public List<Customer> findCustomerByPhone();
	
	@Query("SELECT cust FROM Customer cust WHERE 1=1 AND (cust.id = :#{#param.id})")
	public List<Customer> findCustomerByid(@Param("param") Customer customer);
    
}