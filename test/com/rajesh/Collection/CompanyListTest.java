package com.rajesh.Collection;

import com.rajesh.model.Company;

import static org.junit.jupiter.api.Assertions.*;

class CompanyListTest {


    private static CompanyList list_company;
    private static Company c1;
    private static Company c2;

    @org.junit.jupiter.api.BeforeAll
    static void initialize()
    {
        list_company = new CompanyList();
        c1 = new Company(1,"abc");
        c2 = new Company(2,"xyz");
    }

    @org.junit.jupiter.api.Test
    void insertCompany() {
        assertTrue(list_company.insertCompany(c1));
        assertTrue(list_company.insertCompany(c2));
    }

    @org.junit.jupiter.api.Test
    void searchCompany() {
        assertNotNull(list_company.searchCompany(1));
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertFalse(list_company.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void findCompany() {

        assertNotNull(list_company.findCompany(1));
    }

    @org.junit.jupiter.api.Test
    void removeCompany() {

        assertTrue(list_company.removeCompany(1));
        assertFalse(list_company.searchCompany(1));
    }

    @org.junit.jupiter.api.Test
    void getCompany() {
    }

}