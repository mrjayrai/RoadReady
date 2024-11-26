package com.hexaware.roadready.restcontroller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.roadready.dto.LoginDTO;
import com.hexaware.roadready.dto.UserDTO;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.services.IUserService;
import com.hexaware.roadready.services.JWTService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users/")
public class UserRestController {
	
	@Autowired
	IUserService service;
	
	@Autowired
	JWTService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	Logger logger = LoggerFactory.getLogger(UserRestController.class);
	
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
	private Users addUser(@RequestBody @Valid UserDTO user) {
		return service.addUser(user);
	}
	
	@PostMapping("login")
	private String authenticate(@RequestBody LoginDTO login ) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getUserName(), login.getUserPassword()));
		
		String token = null;

		if (authentication.isAuthenticated()) {

			// call generate token method from jwtService class

			token = jwtService.generateToken(login.getUserName());

			logger.info("Token : " + token);

		} else {

			logger.info("invalid");

			throw new UsernameNotFoundException("UserName or Password in Invalid / Invalid Request");

		}

		return token;
	}
	
	@PutMapping("update")
	private Users updateUser(@RequestBody @Valid UserDTO updateUser) {
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
	@PutMapping("/update/modifyreviewbyuser")
	public String modifyReview(@RequestBody @Valid Reviews review) {
		service.updateReviewByUser(review);
		return "Review updated via users";
		
	}
	@GetMapping("getReviewsByUserId/{userId}")
	public List<Reviews> getReviewsByUserId(@PathVariable int userId){
		return service.getReviewsByUserId(userId);
	}
	
//	@PostMapping("")

}
