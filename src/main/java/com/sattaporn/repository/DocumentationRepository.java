package com.sattaporn.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.Documentation;

import org.springframework.data.repository.CrudRepository;

@Repository
@Transactional(readOnly = true)
public interface DocumentationRepository extends CrudRepository<Documentation,Integer>{

}
