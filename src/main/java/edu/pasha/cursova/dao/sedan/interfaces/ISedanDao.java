package edu.pasha.cursova.dao.sedan.interfaces;

import edu.pasha.cursova.model.Sedan;

import java.util.List;

public interface ISedanDao {
    Sedan save(Sedan sedan);
    Sedan get(String id);
    List<Sedan> getAll();
    Sedan edit(Sedan sedan);
    Sedan delete(String id);
}
