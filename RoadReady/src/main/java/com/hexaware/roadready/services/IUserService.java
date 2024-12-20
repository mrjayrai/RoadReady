package com.hexaware.roadready.services;
/*
 * Author : Shreyasi
 * Description : Service interface for business logic for users
 * Date: 18-11-2024
 */
import java.util.List;

import com.hexaware.roadready.dto.UserDTO;
import com.hexaware.roadready.entities.Reviews;
import com.hexaware.roadready.entities.Users;


public interface IUserService {
	List<Users> getAllUsers();
    List<Users> getUserById(int userId);
    Users addUser(UserDTO user);
    Users updateUser( UserDTO updatedUser);
    void deleteUser(int userId);
    List<Users> findByUsername(String username);
    boolean validateUserCredentials(String username, String password);
    void updateReviewByUser(Reviews review);
    List<Reviews> getReviewsByUserId(int userId);
}
