package com.hexaware.roadready.services;

import java.util.List;

import com.hexaware.roadready.entities.Users;


public interface IUserService {
	List<Users> getAllUsers();
    List<Users> getUserById(int userId);
    Users addUser(Users user);
    Users updateUser( Users updatedUser);
    void deleteUser(int userId);
    List<Users> findByUsername(String username);
    boolean validateUserCredentials(String username, String password);
}
