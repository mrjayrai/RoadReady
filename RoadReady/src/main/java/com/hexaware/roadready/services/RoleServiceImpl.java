package com.hexaware.roadready.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.repositories.RoleRepository;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private RoleRepository roleRepo;
	
	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return roleRepo.findAll();
	}

	@Override
	public List<Role> getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return roleRepo.findByRoleId(roleId);
	}

	@Override
	public Role addRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role updateRole) {
		// TODO Auto-generated method stub
		return roleRepo.save(updateRole);
	}

	@Override
	public void deleteRole(int roleId) {
		// TODO Auto-generated method stub
		roleRepo.deleteByRoleId(roleId);
	}

}
