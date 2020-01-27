package com.rajesh.model;

import com.rajesh.Collection.EmployeeList;

import java.util.List;

public class Company {
	
	private int id;
	
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private EmployeeList employee_list;
		
	public EmployeeList getEmployee_list() {
		return employee_list;
	}
	public Company(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		employee_list = new EmployeeList();
	}

	
	public int getId() {
		return id;
	}
	
	public void setEmployee_list(EmployeeList employee_list) {
		this.employee_list = employee_list;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", employee_list=" + employee_list.toString() + "]";
	}
	
	
	
}
