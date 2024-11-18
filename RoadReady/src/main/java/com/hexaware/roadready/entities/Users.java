package com.hexaware.roadready.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    
    @NotNull(message = "Email cannot be null")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    @Size(max = 255, message = "Email must not exceed 255 characters")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "Password cannot be null")
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
        )
    @Column(name = "password", nullable = false)
    private String password;

    
    @NotNull(message = "Phone number cannot be null")
    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotNull(message = "Role cannot be null")
    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "role_id")
    private Role role;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", updatable = false)
    private LocalDateTime createdAt;

    // Getters and Setters
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

	public Users() {
		super();
	}
	

	public Users(int userId) {
		super();
		this.userId = userId;
	}

	public Users(int userId, String email, String password, String phoneNumber, Role role, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.role = role;
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", email=" + email + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", role=" + role + ", createdAt=" + createdAt + "]";
	}
    
}

