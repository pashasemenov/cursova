package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Customers;
import edu.pasha.cursova.service.customers.Impls.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomersAPIController{
    @Autowired
    CustomersServiceImpl service;

    @RequestMapping("/list")
    List<Customers> getAll() {
        return service.getAll();
    }

}
