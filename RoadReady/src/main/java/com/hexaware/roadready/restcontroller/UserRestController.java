package com.hexaware.roadready.restcontroller;

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

import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.services.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users/")
public class UserRestController {
	
	@Autowired
	IUserService service;
	
	@GetMapping("allusers")
	private List<Users> getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("user/{userId}")
	private List<Users> getUserById(@PathVariable int userId){
		System.out.println(userId);
		return service.getUserById(userId);
	}
	
	@PostMapping("add")
	private Users addUser(@RequestBody @Valid Users user) {
		return service.addUser(user);
	}
	
	@PutMapping("update")
	private Users updateUser(@RequestBody @Valid Users updateUser) {
		return service.updateUser(updateUser);
	}
	
	@DeleteMapping("delete/{deleteId}")
	private void deleteUser(@PathVariable int deleteId) {
		service.deleteUser(deleteId);
	}
	
	@GetMapping("user/username/{userName}")
	private List<Users> getUserByUserName(@PathVariable String userName){
		return service.findByUsername(userName);
	} 
	
//	@PostMapping("")

}
