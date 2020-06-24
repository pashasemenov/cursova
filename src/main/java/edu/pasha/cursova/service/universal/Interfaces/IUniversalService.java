package edu.pasha.cursova.service.universal.Interfaces;

import edu.pasha.cursova.model.Universal;

import java.util.List;

public interface IUniversalService {
    Universal save(Universal universal);
    Universal get(String id);
    List<Universal> getAll();
    Universal edit(Universal universal);
    Universal delete(String id);
}

