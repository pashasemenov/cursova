package edu.pasha.cursova.dao.cabriolet.impls;

import edu.pasha.cursova.dao.cabriolet.interfaces.ICabrioletDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Cabriolet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CabrioletDaoImplFake implements ICabrioletDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Cabriolet save(Cabriolet cabriolet) {
        return null;
    }

    @Override
    public Cabriolet get(String id) {
        return null;
    }

    @Override
    public List<Cabriolet> getAll() {
        return dataSet.getCabriolet();
    }

    @Override
    public Cabriolet edit(Cabriolet cabriolet) {
        return null;
    }

    @Override
    public Cabriolet delete(String id) {
        return null;
    }
}
