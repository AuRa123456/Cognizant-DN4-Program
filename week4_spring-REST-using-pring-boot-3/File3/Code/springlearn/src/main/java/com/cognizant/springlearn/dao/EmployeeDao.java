package com.cognizant.springlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Employee;

@Repository
public class EmployeeDao {

    private static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", List.class);
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}