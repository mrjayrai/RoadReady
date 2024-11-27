package com.hexaware.roadready.dto;
/*
 * Author : Shreyasi
 * Description : DTO for users
 * Date: 23-11-2024
 */
import java.time.LocalDateTime;

import com.hexaware.roadready.entities.Role;

public class UserDTO {
	private int userId;

    private String email;

    private String name;

    private String password;

    private String phoneNumber;

    private Role roleId; 

    private LocalDateTime createdAt;

	public UserDTO() {
		super();
	}

	public UserDTO(int userId, String email, String name, String password, String phoneNumber, Role roleId,
			LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.email = email;
		this.name = name;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
    
    
    
    
    
}
