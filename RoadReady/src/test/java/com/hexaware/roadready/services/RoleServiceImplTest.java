package com.hexaware.roadready.services;
/*
 * Author : Pritesh Rai
 * Description : Test Class for roles
 * Date: 19-11-2024
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.RoleDTO;
import com.hexaware.roadready.entities.Role;
@SpringBootTest
class RoleServiceImplTest {
	
	@Autowired
	IRoleService roleService;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testGetAllRoles() {
     List<Role> roleList=roleService.getAllRoles();
     assertNotNull(roleList);
		
	}

	@Test
	void testGetRoleById() {
//		fail("Not yet implemented");
		int roleId=1;
		List<Role> roleList=roleService.getRoleById(roleId);
		 assertNotNull(roleList);
	}

	@Test
	void testAddRole() {
//		fail("Not yet implemented");
		RoleDTO role=new RoleDTO();
		role.setRoleName("Admin");
		Role addRole=roleService.addRole(role);
		assertEquals(addRole.getRoleId(),6);
	}

	@Test
	void testUpdateRole() {
//		fail("Not yet implemented");
		RoleDTO role=new RoleDTO();
		role.setRoleName("Driver");
		Role updateRole=roleService.updateRole(role);
		assertEquals(updateRole.getRoleName(),"Driver");
	}

	@Test
	void testDeleteRole() {
//		fail("Not yet implemented");
		Role role=new Role();
		role.setRoleId(3);
		roleService.deleteRole(3);
		
		
	}

}
