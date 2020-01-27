package com.rajesh.model;

import org.joda.time.DateTime;

public class Contractor extends Employee{

	private DateTime start;
	private DateTime end;
	private double hourlyRate;


	public Contractor(DateTime start, DateTime end, double perhour) {

		this.start = start;
		this.end = end;
		this.hourlyRate = perhour;
	}


	public DateTime getStart() {
		return start;
	}


	public DateTime getEnd() {
		return end;
	}


	public double getHourlyRate() {
		return hourlyRate;
	}

	



}
