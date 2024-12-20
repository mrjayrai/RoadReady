package com.hexaware.roadready.repositories;
/*
 * Author : Pritesh Rai
 * Description : Repository/DAO Interface for roles
 * Date: 18-11-2024
 */
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexaware.roadready.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
	
	List<Role> findByRoleId(int roleId);
	
	@Modifying
	@Transactional
	void deleteByRoleId(int roleId);
	
	
}
