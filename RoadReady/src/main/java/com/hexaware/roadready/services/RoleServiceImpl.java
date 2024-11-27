package com.hexaware.roadready.services;
/*
 * Author : Pritesh Rai
 * Description : Service Implementation for roles
 * Date: 18-11-2024
 */
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.dto.RoleDTO;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepo;
	Logger logger =	   LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
       logger.info("All role details received");
		return roleRepo.findAll();
	}

	@Override
	public List<Role> getRoleById(int roleId) {
		// TODO Auto-generated method stub
	       logger.info("Role details received by roleid");
		return roleRepo.findByRoleId(roleId);
	}

	@Override
	public Role addRole(RoleDTO role) {
		// TODO Auto-generated method stub
		Role roleEntity = new Role();
		roleEntity.setRoleName(role.getRoleName());
	       logger.info("New Role details added");
		return roleRepo.save(roleEntity);
	}

	@Override
	public Role updateRole(RoleDTO updateRole) {
		// TODO Auto-generated method stub
	       logger.info("Exist role details updated");
	       Role roleEntity = new Role();
			roleEntity.setRoleName(updateRole.getRoleName());
			roleEntity.setRoleId(updateRole.getRoleId());
		return roleRepo.save(roleEntity);
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		logger.error("Role details deleted");
		roleRepo.deleteByRoleId(roleId);
	}

}
