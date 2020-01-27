package com.rajesh.model;

public class Phone {
	
	private int phone_id;
	private String areaCode;
	private String number;
	private String countryCode;
	
	public Phone(){
		
	}
	public Phone(int phone_id, String areaCode, String number, String countryCode) {
		super();
		this.phone_id = phone_id;
		this.areaCode = areaCode;
		this.number = number;
		this.countryCode = countryCode;
	}

	@Override
	public String toString() {
		return "Phone [phone_id=" + phone_id + ", areaCode=" + areaCode + ", number=" + number + ", countryCode="
				+ countryCode + "]";
	}
	
	

}
