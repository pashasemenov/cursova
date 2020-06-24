package edu.pasha.cursova.service.customers.Interfaces;

import edu.pasha.cursova.model.Customers;

import java.util.List;

public interface ICustomersService {
    Customers save(Customers customers);
    Customers get(String id);
    List<Customers> getAll();
    Customers edit(Customers customers);
    Customers delete(String id);
}
