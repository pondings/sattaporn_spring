package com.sattaporn.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sattaporn.dto.PermissionAccessDTO;
import com.sattaporn.model.User;

@Repository
@Transactional(readOnly= true)
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT user FROM User user WHERE user.username = :#{#param}")
	public User findUserByUsername(@Param("param") String username);
	
	@Query("SELECT new com.sattaporn.dto.PermissionAccessDTO(mn.id,u.id,mp.name,mn.name) "
			+ "FROM User u JOIN u.userRoles ur "
			+ "JOIN ur.role ro JOIN ro.permissions per "
			+ "JOIN per.menuPermission mp JOIN mp.menu mn WHERE u.id = :#{#param.userId} "
			+ "AND mn.name = :#{#param.menuName}")
	public PermissionAccessDTO checkPermission(@Param("param") PermissionAccessDTO permissionAccessDTO) ;
	
}
