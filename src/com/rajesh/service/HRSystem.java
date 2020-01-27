package com.rajesh.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.rajesh.Collection.CompanyList;
import com.rajesh.Collection.EmployeeList;
import com.rajesh.model.Company;
import com.rajesh.model.Employee;

public class HRSystem {


	private  Scanner sc;
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private CompanyList list_company;
	private EmployeeList list_employee;


	public HRSystem()
	{

		sc = new Scanner();
		list_company = new CompanyList();
		list_employee = new EmployeeList();
	}





	public void addCompany(Company c)
	{
		if(list_company.insertCompany(c))
			System.out.println("Company added successfully");
		else
			System.out.println("Error in adding company");

	}

	public void addEmployee()
	{
		int company_id =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id))
		{
			Company c1=list_company.findCompany(company_id);

			list_employee =c1.getEmployee_list();
			Employee e = sc.enterEmployeeData();
			if(list_employee.isEmpty() || !list_employee.searchEmployee(e.getId()) )
				list_employee.insertEmployee(e);
			else
				System.out.println("Employee with the given employee id already exist");
			c1.setEmployee_list(list_employee);
			list_company.removeCompany(c1.getId());
			list_company.insertCompany(c1);
		}
		else{
			System.out.println("No company record ");
		}

	}
	public void search_company(int company_id)
	{

		if(!list_company.searchCompany(company_id)) {
			System.out.println("No company records");

		}
		else {
			if (null != list_company.findCompany(company_id)) {
				System.out.println(list_company.findCompany(company_id));

			}
		}
	}

	public void searchEmployee()
	{
		int company_id3 =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id3)) {
			String params = sc.getToken("Enter employee id or firstname,lastname");
			String[] args = params.trim().split(",");
			String first="";
			String last = "";
			int employee_id=0;
			if(args.length ==1)
				 employee_id =Integer.parseInt(args[0]);
			else{
				first = args[0];
				last =args[1];
			}
			Company c1 = list_company.findCompany(company_id3);
			list_employee = c1.getEmployee_list();
			if (list_employee.searchEmployee(employee_id) || list_employee.searchEmployee(first,last) )
				System.out.println("employee records for this in in this company");
			else
				System.out.println("No Employee with the given employee id or this name exist");
		}
		else {
			System.out.println("No company data");
		}
	}

	public void removeEmployee()
	{
		int company_id =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id))
		{
			int employee_id =sc.getInteger("Enter employee id");
			Company c1=list_company.findCompany(company_id);

			list_employee =c1.getEmployee_list();
			if(list_employee.searchEmployee(employee_id))
			{
				if(list_employee.removeEmployee(employee_id))
					System.out.println("Employee record removed.");
			}
			else
			{
				System.out.println("No employee with this id for this company");
			}
		}
		else
		{
			System.out.println("No company records for this id");
		}


	}

	public void add_address()
	{
		int company_id =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id))
		{
			Company c1=list_company.findCompany(company_id);
			int employee_id =sc.getInteger("Enter employee id");
			list_employee =c1.getEmployee_list();
			if(list_employee.searchEmployee(employee_id))
			{
				Employee e =list_employee.findEmployee(employee_id);
				e.setAddress(sc.addAddress());
			}
			else
			{
				System.out.println("No employee record");
			}

		}
		else
		{
			System.out.println("No company record");
		}

	}

	public void add_phone()
	{
		int company_id =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id))
		{
			Company c1=list_company.findCompany(company_id);
			int employee_id =sc.getInteger("Enter employee id");
			list_employee =c1.getEmployee_list();
			if(list_employee.searchEmployee(employee_id))
			{
				Employee e =list_employee.findEmployee(employee_id);
				e.setPhone(sc.addPhone());
			}
			else
			{
				System.out.println("No employee record");
			}

		}
		else
		{
			System.out.println("No company record");
		}

	}

	public void add_Roles()
	{
		int company_id =sc.getInteger("Enter company id");
		if( list_company.searchCompany(company_id)) {
			Company c1 = list_company.findCompany(company_id);
			int employee_id = sc.getInteger("Enter employee id");
			list_employee = c1.getEmployee_list();
			if (list_employee.searchEmployee(employee_id)) {

				Employee e =list_employee.findEmployee(employee_id);
				e.setRole(sc.addRoles());

			}
			else
			{
				System.out.println("No employee record");
			}
		}
		else
		{
			System.out.println("No company record");
		}

	}

	public void add_other_info()
	{
		boolean exit = true;
		do {


			System.out.println("Press 1 to add Employee Address");
			System.out.println("Press 2 to add Employee Phone");
			System.out.println("Press 3 to add Employee Roles");
			System.out.println("Press 4 to show Employee Details");
			System.out.println("Press 0 to exit this state");
			int value = sc.getInteger(" ");

			switch (value) {
				case 1:
					add_address();
					break;

				case 2:
					add_phone();
					break;
				case 3:
					add_Roles();
					break;
				case 4:
					list_employee.display();
					break;
				case 0:
					exit = false;

				default:
					System.out.println("Enter the specified values");
					break;

			}

			list_employee.display();
		} while (exit);


	}
	public void help()
	{
		boolean loop =true;
		do {

			System.out.println("Press 1 to add Company");
			System.out.println("Press 2 to add Employee ");
			System.out.println("Press 3 to search company");
			System.out.println("Press 4 to search employee");
			System.out.println("Press 5 to remove company");
			System.out.println("Press 6 to remove employee");
			System.out.println("Press 7 to add other Employee Details");
			System.out.println("Press 0 to exit");
			int value = sc.getInteger(" ");
			if(value ==0 ) loop =false;
			switch(value)
			{
			case 1:
				Company c = sc.enterCompanyData();
				addCompany(c);
				
			break;
			case 2:
				addEmployee();

			break;
			case 3:	
				int company_id1 =sc.getInteger("Enter company id");
				search_company(company_id1);
			break;
			case 4:
				searchEmployee();
			break;

			case 5: int id1 =sc.getInteger("Enter company id");

			if(list_company.removeCompany(id1))
			{
				System.out.println("Remove company with this id ");
			}
			break;
			
			case 6:
				removeEmployee();
			break;
			case 7:
				add_other_info();
			break;
			}
			list_company.display();


		}while(loop);
	}



}
