package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QuerriesFacadeSearcherTest {
    @Autowired
    QuerriesFacadeSearcher querriesFacadeSearcher;
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    CompanyDao companyDao;

    @Test
    public void shouldFindEmployeeByStringFragment() {
        //Given
        Employee employee1 = new Employee("Alan", "Galeza");
        Employee employee2 =new Employee("Jack", "Daniels");

        employeeDao.save(employee1);
        employeeDao.save(employee2);

        //When
        List<Employee> employeeListResult = querriesFacadeSearcher.employeesSearcher("%Gal%");

        //Then
        assertThat(employeeListResult.size()).isEqualTo(1);
        assertThat(employeeListResult.get(0).getFirstname()).isEqualTo("Alan");

        //CleanUp
        try {
            employeeDao.deleteAll();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }

    @Test
    public void shouldFindCompanyNameByStringFragment() {
        //Given
        Company company1 = new Company("SoftwareSpecialists");
        Company company2 = new Company("ProgrammingLeaders");
        Company company3 = new Company("House of Code");

        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        //When
        List<Company> companyListResult = querriesFacadeSearcher.companiesSearcher("%Soft%");

        //Then
        assertThat(companyListResult.size()).isEqualTo(1);
        assertThat(companyListResult.get(0).getName()).isEqualTo("SoftwareSpecialists");

        //CleanUp
        try {
            companyDao.deleteAll();
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}