package edu.pasha.cursova.service.employees.interfaces;

import edu.pasha.cursova.model.Employees;

import java.util.List;

public interface IEmployeesService {
    Employees save(Employees employees);
    Employees get(String id);
    List<Employees> getAll();
    Employees edit(Employees employees);
    Employees delete(String id);
}
