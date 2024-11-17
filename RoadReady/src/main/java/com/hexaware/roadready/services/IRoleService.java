package com.hexaware.roadready.services;

import java.util.List;

import com.hexaware.roadready.entities.Role;


public interface IRoleService {
	List<Role> getAllRoles();
	List<Role> getRoleById(int roleId);
	Role addRole(Role role);
	Role updateRole(Role updateRole);
	void deleteRole(int roleId);
}
