package edu.pasha.cursova.dao.employees.interfaces;

import edu.pasha.cursova.model.Employees;

import java.util.List;

public interface IEmployeesDao {
    Employees save(Employees employees);
    Employees get(String id);
    List<Employees> getAll();
    Employees edit(Employees employees);
    Employees delete(String id);
}
