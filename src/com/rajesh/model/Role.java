package com.rajesh.model;

public class Role {

	private int id;
	private String role_name;
	public Role() {
		
	}
	
	public Role(int id, String role_name) {
		super();
		this.id = id;
		this.role_name = role_name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", role_name=" + role_name + "]";
	}
	
	
}


