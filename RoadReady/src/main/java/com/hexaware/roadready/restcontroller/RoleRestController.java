package com.hexaware.roadready.restcontroller;
/*
 * Author : Pritesh Rai
 * Description : Rest COntrollers for roles
 * Date: 17-11-2024
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.RoleDTO;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.services.IRoleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/roles/")
public class RoleRestController {
	
	@Autowired
	private IRoleService service;
	
	@GetMapping("allroles")
	private List<Role> getAllRoles(){
		return service.getAllRoles();
	}
	
	@GetMapping("role/{roleId}")
	private List<Role> getRoleById(@PathVariable int roleId){
		return service.getRoleById(roleId);
	}
	
	@PostMapping("add")
	private Role addRole(@RequestBody @Valid RoleDTO role) {
		return service.addRole(role);
	}
	
	@PutMapping("update")
	private Role updateRole(@RequestBody @Valid RoleDTO role) {
		return service.updateRole(role);
	}
	
	@DeleteMapping("delete/{roleId}")
	private void deleteRole(@PathVariable int roleId) {
		 service.deleteRole(roleId);
	}
	
}
