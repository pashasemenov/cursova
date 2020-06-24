package edu.pasha.cursova.dao.technicalData.impls;

import edu.pasha.cursova.dao.technicalData.interfaces.ITechnicalDataDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.TechnicalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TechnicalDataDaoImplFake implements ITechnicalDataDao {

    @Autowired
    DataSet dataSet;

    @Override
    public TechnicalData save(TechnicalData technicalData) {
        return null;
    }

    @Override
    public TechnicalData get(String id) {
        return null;
    }

    @Override
    public List<TechnicalData> getAll() {
        return dataSet.getTechnicalData();
    }

    @Override
    public TechnicalData edit(TechnicalData technicalData) {
        return null;
    }

    @Override
    public TechnicalData delete(String id) {
        return null;
    }
}
