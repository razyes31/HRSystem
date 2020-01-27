package com.rajesh.model;

import java.util.List;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private Address address;
	
	private Phone phone;
	private List<Role> role;
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}


	public Employee() {

	}
	public Employee(int id, String firstName, String lastName) {

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Address getAddress() {
		return address;
	}

	public Phone getPhone() {
		return phone;
	}

	public List<Role> getRole() {
		return role;
	}

	public boolean equals(int id)
	{
		return (this.id == id);
		
	}


	public void setId(int id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", phone=" + phone + ", role=" + role + "]";
	}






}
