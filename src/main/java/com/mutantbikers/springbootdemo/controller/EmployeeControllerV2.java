package com.mutantbikers.springbootdemo.controller;

import com.mutantbikers.springbootdemo.model.Employee;
import com.mutantbikers.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2/employee") //Base path -> Mapping on class level
public class EmployeeControllerV2 {

    @Qualifier("employeeServiceV2Impl")
    @Autowired
    private EmployeeService employeeService;


    //Save employee
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    //Get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Get employee with ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    //Delete employee by ID
    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable String id){
        return employeeService.deleteEmployeeById(id);
    }


}
