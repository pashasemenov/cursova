package edu.pasha.cursova.dao.universal.impls;

import edu.pasha.cursova.dao.universal.interfaces.IUniversalDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Universal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UniversalDaoImplFake implements IUniversalDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Universal save(Universal universal) {
        return null;
    }

    @Override
    public Universal get(String id) {
        return null;
    }

    @Override
    public List<Universal> getAll() {
        return dataSet.getUniversal();
    }

    @Override
    public Universal edit(Universal universal) {
        return null;
    }

    @Override
    public Universal delete(String id) {
        return null;
    }
}
