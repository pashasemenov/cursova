package edu.pasha.cursova.dao.coupe.impls;

import edu.pasha.cursova.dao.coupe.interfaces.ICoupeDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Coupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CoupeDaoImplFake implements ICoupeDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Coupe save(Coupe coupe) {
        return null;
    }

    @Override
    public Coupe get(String id) {
        return null;
    }

    @Override
    public List<Coupe> getAll() {
        return dataSet.getCoupe();
    }

    @Override
    public Coupe edit(Coupe coupe) {
        return null;
    }

    @Override
    public Coupe delete(String id) {
        return null;
    }
}

