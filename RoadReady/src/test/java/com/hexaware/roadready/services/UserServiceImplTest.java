package com.hexaware.roadready.services;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexaware.roadready.dto.UserDTO;
import com.hexaware.roadready.entities.Role;
import com.hexaware.roadready.entities.Users;
import com.hexaware.roadready.exceptions.NotFoundException;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    IUserService service;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
    }

    @Test
    void testGetUserById() {
        int id = 1;
        List<Users> userList = service.getUserById(id);
        assertNotNull(userList);
        assertFalse(userList.isEmpty());
        assertEquals(id, userList.get(0).getUserId());
    }

    @Test
    void testGetAllUsers() {
        List<Users> users = service.getAllUsers();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    void testAddUser() {
        Role role = new Role();
        role.setRoleId(1); // Assuming a role with ID 2 exists in the database.

        UserDTO user = new UserDTO();
        user.setEmail("newuseu@gmail.com");
        user.setPassword("SecurePassword1@");
        user.setPhoneNumber("1234567999");
        user.setRoleId(role);
        user.setCreatedAt(LocalDateTime.now());

        Users createdUser = service.addUser(user);
        assertNotNull(createdUser);
       // assertEquals(user.getEmail(), createdUser.getEmail());
    }

    @Test
    void testUpdateUser() {
        Role role = new Role();
        role.setRoleId(1);

        UserDTO user = new UserDTO();
        user.setUserId(1); // Assuming a user with ID 1 exists in the database.
        user.setEmail("updateduser@example.com");
        user.setPassword("UpdatedPassword1@");
        user.setPhoneNumber("9876543210");
        user.setRoleId(role);

        Users updatedUser = service.updateUser(user);
        assertNotNull(updatedUser);
        assertEquals(user.getEmail(), updatedUser.getEmail());
    }

    @Test
    void testDeleteUser() {
        int id = 6; // Assuming a user with ID 3 exists in the database.
        service.deleteUser(id);


        List<Users> user = service.getUserById(id);
        assertTrue(user.isEmpty());
    }
}
