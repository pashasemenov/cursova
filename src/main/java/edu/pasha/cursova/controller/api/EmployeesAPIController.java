package edu.pasha.cursova.controller.api;


import edu.pasha.cursova.model.Employees;
import edu.pasha.cursova.service.employees.impls.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeesAPIController{
    @Autowired
    EmployeesServiceImpl service;

    @RequestMapping("/list")
    List<Employees> getAll() {
        return service.getAll();
    }

}
