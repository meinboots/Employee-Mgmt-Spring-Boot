package com.mutantbikers.springbootdemo.service;

import com.mutantbikers.springbootdemo.exception.EmployeeNotFoundException;
import com.mutantbikers.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{
         //Creating a list to save employee temporarily
        List<Employee> employees =  new ArrayList<>();

    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() ==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException(""+"Employee not found with the provided Id : " +id ));
    }
}
