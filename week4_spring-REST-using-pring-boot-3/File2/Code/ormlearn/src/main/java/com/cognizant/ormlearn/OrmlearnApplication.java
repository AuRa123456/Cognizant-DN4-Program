package com.cognizant.ormlearn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@SpringBootApplication
public class OrmlearnApplication {

    @Autowired
    private static EmployeeService employeeService;
    @Autowired
    private static DepartmentService departmentService;
    @Autowired
    private static SkillService skillService;

    public static void main(String[] args) {
        var context = SpringApplication.run(OrmlearnApplication.class, args);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();
    }

    private static void testGetEmployee() {
        var employee = employeeService.get(1);
        System.out.println("Employee: " + employee);
        System.out.println("Department: " + employee.getDepartment());
        System.out.println("Skills: " + employee.getSkillList());
    }
}