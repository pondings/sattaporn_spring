package com.sattaporn.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.model.ServiceInfo;

@Repository
@Transactional(readOnly=true)
public interface APIInfoRepository extends CrudRepository<ServiceInfo, Integer>{

}
