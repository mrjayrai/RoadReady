package com.hexaware.roadready.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.repositories.UsersRepository;


@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UsersRepository userRepo;
	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public List<Users> getUserById(int userId) {
		// TODO Auto-generated method stub
		return userRepo.findByUserId(userId);
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

}
