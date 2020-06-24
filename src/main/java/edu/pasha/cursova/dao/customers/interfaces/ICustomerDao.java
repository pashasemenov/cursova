package edu.pasha.cursova.dao.customers.interfaces;

import edu.pasha.cursova.model.Customers;

import java.util.List;

public interface ICustomerDao {
    Customers save(Customers customers);
    Customers get(String id);
    List<Customers> getAll();
    Customers edit(Customers customers);
    Customers delete(String id);
}
