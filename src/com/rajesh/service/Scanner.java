package com.rajesh.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import com.rajesh.model.*;
import org.joda.time.DateTime;

public class Scanner {

	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


	public String getToken(String prompt) {
		do {
			try {
				System.out.println(prompt);
				String line = reader.readLine();
				StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");
				if (tokenizer.hasMoreTokens()) {
					return tokenizer.nextToken();
				}
			} catch (IOException ioe) {
				System.exit(0);
			}
		} while (true);
	}


	public boolean yesOrNo(String prompt) {
		String more = getToken(prompt + " (Y|y)[es] or anything else for no");
		if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
			return false;
		}
		return true;
	}

	private double getDouble(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Double num = Double.valueOf(item);
				return num.doubleValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	public int getInteger(String prompt) {
		do {
			try {
				String item = getToken(prompt);
				Integer num = Integer.valueOf(item);
				return num.intValue();
			} catch (NumberFormatException nfe) {
				System.out.println("Please input a number ");
			}
		} while (true);
	}

	private DateTime getDate(String prompt) {
		do {
			try {
				Calendar date = new GregorianCalendar();
				String item = getToken(prompt);
				DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
				date.setTime(df.parse(item));



				return new DateTime(date.getTime());
			} catch (Exception fe) {
				System.out.println("Please input a date as mm/dd/yy");
			}
		} while (true);
	}


	public Company enterCompanyData() {
		int id = (this.getInteger("Enter company id"));
		String name = getToken("Enter company name:");
		return new Company(id, name);
	}

	public Employee enterEmployeeData() {
		String more = getToken("Enter Type of Employee (Contract or FullTIME)\n "
				+ "Type C|c for contract or anything else for fulltime");
		Employee e = null;

		int id = (this.getInteger("Enter the employee id"));
		String firstname = this.getToken("Enter first name: ");
		String lastname = this.getToken("Enter last name: ");

		if (more.charAt(0) != 'C' && more.charAt(0) != 'c') {
			//fulltime
			DateTime start = this.getDate("Enter startdate: ");
			double salary = this.getInteger("enter annual salayr");
			double bonus = this.getInteger("enter bonus ");
			e = new FullTime(start, salary, bonus);

		} else {
			DateTime start = this.getDate("Enter startdate: ");
			DateTime end = this.getDate("Enter enddate: ");
			double perhour = this.getDouble("enter perhour rate ");
			e = new Contractor(start, end, perhour);
			//contract

		}


		e.setId(id);
		e.setFirstName(firstname);
		e.setLastName(lastname);

		return e;
	}


	public Address addAddress() {
		System.out.println("Enter address information");
		int address_id = this.getInteger("Enter address id: ");
		String zip = this.getToken("Enter zip name: ");
		String country = this.getToken("Enter country name: ");
		String state = this.getToken("Enter state name: ");
		String city = this.getToken("Enter city name: ");
		String line1 = this.getToken("Enter line1 name: ");
		String line2 = this.getToken("Enter line2 name: ");
		Address address = new Address(address_id, zip, country, state, city, line1, line2);

		System.out.println(address.toString());
		return address;
	}

	public Phone addPhone() {
		int phone_id = this.getInteger("Enter phone id: ");
		System.out.println("Enter phone information");
		String areacode = this.getToken("Enter areacode: ");
		String number = this.getToken("Enter number: ");
		String countrycode = this.getToken("Enter countrycode: ");
		Phone phone = new Phone(phone_id, areacode, number, countrycode);
		return phone;
	}


	public List<Role> addRoles() {
		System.out.println("Adding roles:");
		List<Role> roles = new ArrayList<Role>();
		do {

			int role_id = this.getInteger("Enter role id: ");
			String rolename = this.getToken("Enter role name: ");
			Role r = new Role(role_id, rolename);
			roles.add(r);


		} while (yesOrNo("Do you want to add another role ?"));
		return roles;


	}

}