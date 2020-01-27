package com.rajesh.model;

import org.joda.time.DateTime;

public class FullTime extends Employee{
	private DateTime start;
	private double baseSalaryPerYear;
	private double bonusPerYear;

	public DateTime getStart() {
		return start;
	}



	public double getBaseSalaryPerYear() {
		return baseSalaryPerYear;
	}



	public double getBonusPerYear() {
		return bonusPerYear;
	}







	public FullTime(DateTime start, double salary, double bonus) {
	
	
		this.start = start;
		this.baseSalaryPerYear = salary;
		this.bonusPerYear = bonus;
	}




}
