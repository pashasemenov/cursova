package edu.pasha.cursova.dao.employees.impls;

import edu.pasha.cursova.dao.employees.interfaces.IEmployeesDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeesDaoImplFake implements IEmployeesDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Employees save(Employees employees) {
        return null;
    }

    @Override
    public Employees get(String id) {
        return null;
    }

    @Override
    public List<Employees> getAll() {
        return dataSet.getEmployees();
    }

    @Override
    public Employees edit(Employees employees) {
        return null;
    }

    @Override
    public Employees delete(String id) {
        return null;
    }
}
