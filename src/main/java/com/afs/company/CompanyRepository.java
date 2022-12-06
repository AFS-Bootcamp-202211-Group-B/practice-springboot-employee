package com.afs.company;

import com.afs.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {
    List<Company> companies;

    public CompanyRepository(){
        this.companies = new ArrayList<>();
        companies.add(new Company(1, "abc Company"));
        companies.add(new Company(2, "def Company"));
        companies.add(new Company(3, "ghi Company"));
    }
}
