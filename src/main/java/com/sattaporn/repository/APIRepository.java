package com.sattaporn.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Service;

@Repository
@Transactional(readOnly=true)
public interface APIRepository extends CrudRepository<Service, Integer>{

	public List<Service> findByName(String serviceName) ;
	
	
}
