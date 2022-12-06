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

    public List<Company> findByPage(Integer page, Integer pageSize) {
        int end = pageSize*page > companies.size()? pageSize*page-((pageSize*page)%companies.size()):pageSize*page;
        return companies.subList(pageSize*(page-1),end);
    }

    public Company create(Company company) {
        Integer id = generateNextId();
        company.setId(id);
        companies.add(company);
        return company;
    }

    private Integer generateNextId() {
        int nextId = companies.stream()
                .mapToInt(company -> company.getId())
                .max()
                .orElse(1);
        return nextId + 1;
    }

    public void delete(Company existingCompany) {
        companies.remove(existingCompany);
    }
}
