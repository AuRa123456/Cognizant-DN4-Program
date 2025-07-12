package com.cognizant.springlearn.dao;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("departmentList", List.class);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}