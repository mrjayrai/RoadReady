package com.hexaware.roadready.dto;

public class RoleDTO {
	 private int roleId;
	    private String roleName;

	    public RoleDTO() {
	        super();
	    }

	    public RoleDTO(int roleId, String roleName) {
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
