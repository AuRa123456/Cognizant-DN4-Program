package com.cognizant.springlearn.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.model.Skill;

@Repository
public class EmployeeDao {

    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    static {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Department techDept = new Department(1, "Tech");
            Skill javaSkill = new Skill(1, "Java");
            Skill springSkill = new Skill(2, "Spring");

            EMPLOYEE_LIST.add(new Employee(
                    1,
                    "John Doe",
                    45000.0,
                    true,
                    sdf.parse("15/08/1990"),
                    techDept,
                    Arrays.asList(javaSkill, springSkill)
            ));

            EMPLOYEE_LIST.add(new Employee(
                    2,
                    "Jane Smith",
                    55000.0,
                    false,
                    sdf.parse("22/05/1992"),
                    new Department(2, "HR"),
                    List.of(new Skill(3, "Communication"))
            ));
        } catch (ParseException e) {
            throw new RuntimeException("Error initializing employee list", e);
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                return;
            }
        }
    }

    public void deleteEmployee(int id) {
        EMPLOYEE_LIST.removeIf(emp -> emp.getId() == id);
    }
}