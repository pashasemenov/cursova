package edu.pasha.cursova.service.coupe.Interfaces;

import edu.pasha.cursova.model.Coupe;

import java.util.List;

public interface ICoupeService {
    Coupe save(Coupe coupe);
    Coupe get(String id);
    List<Coupe> getAll();
    Coupe edit(Coupe coupe);
    Coupe delete(String id);
}
