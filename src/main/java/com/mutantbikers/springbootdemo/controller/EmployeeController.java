package com.mutantbikers.springbootdemo.controller;

import com.mutantbikers.springbootdemo.model.Employee;
import com.mutantbikers.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee") //Base path -> Mapping on class level
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //Save employee
    @PostMapping
    public Employee save(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    //Get employee
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    //Get employee with ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }
}
