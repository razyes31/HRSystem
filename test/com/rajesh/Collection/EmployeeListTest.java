package com.rajesh.Collection;

import com.rajesh.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeListTest {

    private static EmployeeList list_employee;
    private static  Employee e1;
    private static  Employee e2;

    @BeforeAll
    public static void initialize()
    {
        list_employee = new EmployeeList();
        e1 = new Employee(1,"rajesh", "bhuju");
        e2 = new Employee(2,"anil","stha");


    }
    @Test
    void insertEmployee() {
        //assertTrue();
        assertTrue(list_employee.insertEmployee(e1));
        assertTrue(list_employee.insertEmployee(e2));
    }

    @Test
    void searchEmployee() {
        assertTrue(list_employee.searchEmployee(1));
        assertTrue(list_employee.searchEmployee(2));
    }

    @Test
    void isEmpty() {
        assertFalse(list_employee.isEmpty());
    }

    @Test
    void findEmployee() {
        assertNull(list_employee.findEmployee(1));
        assertNull(list_employee.findEmployee(3));
    }

    @Test
    void removeEmployee() {
        assertTrue(list_employee.removeEmployee(1));
    }
}