package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Getter
@Service
public class QuerriesFacadeSearcher {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    List<Company> companiesSearcher(String arg) {
        return companyDao.findCompanyByCompanyNameFragment(arg);
    }

    List<Employee> employeesSearcher(String arg) {
        return employeeDao.findEmployeeByLastnameFragment(arg);
    }
}
