package com.hexaware.roadready.services;
/*
 * Author : Shreyasi
 * Description : Service Implementation for users
 * Date: 18-11-2024
 */
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.roadready.dto.UserDTO;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.repositories.UsersRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository userRepo;
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<Users> getUserById(int userId) {
		// TODO Auto-generated method stub
	return userRepo.findByUserId(userId);
//		return userRepo.findById(userId).orElseThrow(()-> new NotFoundException("User with ID " + userId + " not found"));
	}

	@Override
	public Users addUser(UserDTO user) {
		// TODO Auto-generated method stub
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		System.out.println("Added");
		Users userEntity = new Users();
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		userEntity.setRole(user.getRoleId());
		userEntity.setCreatedAt(user.getCreatedAt());
		return userRepo.save(userEntity);
		
	}

	@Override
	public Users updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		Users userEntity = new Users();
		userEntity.setEmail(user.getEmail());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhoneNumber(user.getPhoneNumber());
		userEntity.setRole(user.getRoleId());
		userEntity.setCreatedAt(user.getCreatedAt());
		return userRepo.save(userEntity);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		userRepo.deleteByUserId(userId);
		
	}

	@Override
	public List<Users> findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(username);
	}

	@Override
	public boolean validateUserCredentials(String username, String password) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmailAndPassword(username, password);
	}

	@Override
	public void updateReviewByUser(Reviews review) {
		// TODO Auto-generated method stub
		restTemplate.put("http://localhost:8080/api/reviews/update", review);
		
	}

	@Override
	public List<Reviews> getReviewsByUserId(int userId) {
		// TODO Auto-generated method stub
		String url = "http://localhost:8080/api/reviews/review/user/" + userId;
		List<Reviews> reviewList = Arrays.asList(restTemplate.getForObject(url, Reviews[].class));

		return reviewList;
	}

	

}
