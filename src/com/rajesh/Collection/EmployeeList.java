package com.rajesh.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rajesh.model.Company;
import com.rajesh.model.Employee;

public class EmployeeList

{
	
	public void setEmployee_list(List<Employee> employee_list) {
		this.employee_list = employee_list;
	}

	private List<Employee> employee_list;
	
	public EmployeeList()
	{
		employee_list= new ArrayList<Employee>();
	}
	
	
	public List<Employee> getEmployee_list() {
		return employee_list;
	}

	public boolean insertEmployee(Employee e)
	
	{
		if(!searchEmployee(e.getId())) {
			employee_list.add(e);
			return true;
		}
		else {
		System.out.println("Employee With that Id already exists");
		return false;
		}
		
		
	
	}
	
	public boolean searchEmployee(int id)
	{
		
		for(Employee e :employee_list)
		{
			if(e.getId() ==id)
				return true;
		}
			
		return false;
	}

	public boolean searchEmployee(String firstname, String lastname)
	{

		for(Employee e :employee_list)
		{
			if(e.getFirstName().equalsIgnoreCase(firstname) && e.getLastName().equalsIgnoreCase(lastname))
				return true;
		}

		return false;
	}
	
	public boolean isEmpty()
	{
		if(employee_list.size() ==0)
		{
			
			return true;
		}
		return false;
	}
	
	
	public Employee findEmployee(int id)
	{
		Employee e=null;
		for(Iterator<Employee> iter = getEmployeeList();iter.hasNext();){
			  e = (Employee)iter.next();
			  if(e.equals(id)){
				  return e;
			     
			  }
			}
		
		return null;
	}
	
	public boolean removeEmployee(int id)
	{
		if(searchEmployee(id))
		{
			Employee e = findEmployee(id);
			employee_list.remove(e);
			return true;
		}
		else {
			return false;
		}
	}

	
	public Iterator<Employee> getEmployeeList() {
	    return employee_list.iterator();
	  }
	
	public void display()
	{
		for (Employee e:employee_list)
			System.out.println(e.toString());
	}

	@Override
	public String toString() {
		String temp= "";
		for (Employee e:employee_list)
			temp += e.toString()+'\n';

		return "EmployeeList{" +
				"employee_list=" + temp +
				'}';
	}
}
