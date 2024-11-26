package com.hexaware.roadready.services;

import java.util.List;

import com.hexaware.roadready.dto.RoleDTO;
import com.hexaware.roadready.entities.Role;


public interface IRoleService {
	List<Role> getAllRoles();
	List<Role> getRoleById(int roleId);
	Role addRole(RoleDTO role);
	Role updateRole(RoleDTO updateRole);
	void deleteRole(int roleId);
}
