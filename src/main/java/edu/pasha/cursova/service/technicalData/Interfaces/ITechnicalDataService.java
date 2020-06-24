package edu.pasha.cursova.service.technicalData.Interfaces;

import edu.pasha.cursova.model.TechnicalData;

import java.util.List;

public interface ITechnicalDataService {
    TechnicalData save(TechnicalData technicalData);
    TechnicalData get(String id);
    List<TechnicalData> getAll();
    TechnicalData edit(TechnicalData technicalData);
    TechnicalData delete(String id);
}
