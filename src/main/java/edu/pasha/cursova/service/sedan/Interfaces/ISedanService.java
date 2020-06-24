package edu.pasha.cursova.service.sedan.Interfaces;

import edu.pasha.cursova.model.Sedan;

import java.util.List;

public interface ISedanService {
    Sedan save(Sedan sedan);
    Sedan get(String id);
    List<Sedan> getAll();
    Sedan edit(Sedan sedan);
    Sedan delete(String id);
}
