package com.rajesh.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rajesh.model.Company;

public class CompanyList {

	private List<Company> company_list;

	public List<Company> getCompany_list() {
		return company_list;
	}

	public CompanyList()
	{
		company_list = new ArrayList<Company>();
	}


	public boolean insertCompany(Company c)

	{
		if(isEmpty() || !searchCompany(c.getId())) {
			company_list.add(c);
			return true;
		}
		else {
			System.out.println("Company With that Id already exists");
			return false;
		}

	}

	public boolean searchCompany(int id)
	{

		for(Company c :company_list)
		{
			if(c.getId() ==id)
				return true;
		}

		return false;
	}

	public boolean isEmpty()
	{
		if(company_list.size() ==0)
		{

			return true;
		}
		return false;
	}

	public Company findCompany(int id)
	{

		for(Iterator<Company> iter = getCompany();iter.hasNext();){
			Company c = (Company)iter.next();
			if(id == c.getId()){
				return c;

			}
		}

		return null;
	}

	
	public boolean removeCompany(int id)
	{
		if(searchCompany(id))
		{
			Company c = findCompany(id);
			company_list.remove(c);
			return true;
		}
		else {
			return false;
		}
	}


	public Iterator<Company> getCompany()
	{
		return company_list.iterator();
	}

	public void display()
	{
		String temp = null;
		for(Iterator<Company> iter = getCompany();iter.hasNext();) {
			Company c = (Company) iter.next();
			System.out.println(c.toString());

		}

	}


}
