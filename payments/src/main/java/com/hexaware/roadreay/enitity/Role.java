package com.hexaware.roadreay.enitity;
/*
 * Author : Pritesh Rai
 * Description : Entity for roles
 * Date: 16-11-2024
 */
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id", nullable = false)
	private int roleId;

	@NotNull(message="Role name cannot be null")
	@NotBlank(message="Role name cannot be blank")
	@Size(min = 3,max=25,message="Role name must be between 3 and 25 characters")
	@Column(name = "role_name", nullable = false, length = 25)
	private String roleName;

	public Role() {
		super();
	}

	public Role(int roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
