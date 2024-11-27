package com.hexaware.roadready.services;
/*
 * Author : Pritesh Rai
 * Description : Service interface for business logic for roles
 * Date: 18-11-2024
 */
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
