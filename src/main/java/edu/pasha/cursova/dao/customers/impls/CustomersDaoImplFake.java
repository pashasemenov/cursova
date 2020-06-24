package edu.pasha.cursova.dao.customers.impls;

import edu.pasha.cursova.dao.customers.interfaces.ICustomerDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Customers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomersDaoImplFake implements ICustomerDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Customers save(Customers customers) {
        return null;
    }

    @Override
    public Customers get(String id) {
        return null;
    }

    @Override
    public List<Customers> getAll() {
        return dataSet.getCustomers();
    }

    @Override
    public Customers edit(Customers customers) {
        return null;
    }

    @Override
    public Customers delete(String id) {
        return null;
    }
}
