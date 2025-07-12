package com.cognizant.ormlearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.repository.StockRepository;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private SkillService skillService;

    @GetMapping("/")
    public String healthCheck() {
        return "Spring Boot app is running";
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/employees")
    public Employee getEmployeeSample() {
        return employeeService.get(1); // sample ID
    }

    @GetMapping("/departments")
    public Department getDepartmentSample() {
        return departmentService.get(1); // sample ID
    }

    @GetMapping("/skills")
    public Skill getSkillSample() {
        return skillService.get(1); // sample ID
    }

    @GetMapping("/stocks")
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
}