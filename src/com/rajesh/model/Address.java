package com.rajesh.model;

public class Address {
	
	private int id;
	private String zip;
	private String country;
	private String state;
	private String city;
	private String line1;
	private String line2;
	
	
	public Address()
	{
		
	}
	
	
	public Address(int id, String zip, String country, String state, String city, String line1, String line2) {
		super();
		this.id = id;
		this.zip = zip;
		this.country = country;
		this.state = state;
		this.city = city;
		this.line1 = line1;
		this.line2 = line2;
	}
	
	@Override
	public String toString() {
		return "Address [id=" + id + ", zip=" + zip + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", line1=" + line1 + ", line2=" + line2 + "]";
	}


	

}
