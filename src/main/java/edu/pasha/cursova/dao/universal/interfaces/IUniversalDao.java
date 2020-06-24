package edu.pasha.cursova.dao.universal.interfaces;

import edu.pasha.cursova.model.Universal;

import java.util.List;

public interface IUniversalDao {
    Universal save(Universal universal);
    Universal get(String id);
    List<Universal> getAll();
    Universal edit(Universal universal);
    Universal delete(String id);
}
