package com.sattaporn.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Documentation;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

@Repository
@Transactional(readOnly = true)
public interface DocumentationRepository extends CrudRepository<Documentation,Integer>{

	@Query("SELECT doc FROM Documentation doc LEFT JOIN FETCH doc.customer WHERE doc.customer.code = :#{#param.customer.code}")
	public List<Documentation> findDocument(@Param("param") Documentation documentation) ;
	
	@Query("SELECT doc FROM Documentation doc")
	public List<Documentation> findAll();
	
}
