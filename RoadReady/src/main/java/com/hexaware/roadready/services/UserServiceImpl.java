package com.hexaware.roadready.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.repositories.UsersRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository userRepo;
	@Autowired
	RestTemplate restTemplate;
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
	public Users addUser(Users user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

	@Override
	public Users updateUser(Users updatedUser) {
		// TODO Auto-generated method stub
		return userRepo.save(updatedUser);
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
//		List<Reviews> reviewList=(List<Reviews>) restTemplate.getForObject("http://localhost:8080/api/reviews/review/user/" + userId, Reviews.class);
//		String url = "http://localhost:8080/api/reviews/review/user/" + userId;
//		List<Reviews> reviewList = (List<Reviews>) restTemplate.getForObject(url, Reviews.class);
		String url = "http://localhost:8080/api/reviews/review/user/" + userId;
		List<Reviews> reviewList = Arrays.asList(restTemplate.getForObject(url, Reviews[].class));

		return reviewList;
	}

	

}
