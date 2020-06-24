package edu.pasha.cursova.dao.technicalData.interfaces;

import edu.pasha.cursova.model.TechnicalData;

import java.util.List;

public interface ITechnicalDataDao {
    TechnicalData save(TechnicalData technicalData);
    TechnicalData get(String id);
    List<TechnicalData> getAll();
    TechnicalData edit(TechnicalData technicalData);
    TechnicalData delete(String id);
}
