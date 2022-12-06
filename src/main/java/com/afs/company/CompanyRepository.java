package com.afs.company;

import com.afs.employee.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CompanyRepository {
    List<Company> companies;

    public CompanyRepository(){
        this.companies = new ArrayList<>();
        companies.add(new Company(1, "abc Company"));
        companies.add(new Company(2, "def Company"));
        companies.add(new Company(3, "ghi Company"));
    }
    public List<Company> findAll() {
        return this.companies;
    }

    public Company findById(int id) {
        return companies.stream().filter(company -> company.getId() == id).findFirst().get();
    }
}
