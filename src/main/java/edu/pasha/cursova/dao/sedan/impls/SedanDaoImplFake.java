package edu.pasha.cursova.dao.sedan.impls;

import edu.pasha.cursova.dao.sedan.interfaces.ISedanDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Sedan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SedanDaoImplFake implements ISedanDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Sedan save(Sedan sedan) {
        return null;
    }

    @Override
    public Sedan get(String id) {
        return null;
    }

    @Override
    public List<Sedan> getAll() {
        return dataSet.getSedan();
    }

    @Override
    public Sedan edit(Sedan sedan) {
        return null;
    }

    @Override
    public Sedan delete(String id) {
        return null;
    }
}

