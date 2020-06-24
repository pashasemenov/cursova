package edu.pasha.cursova.dao.coupe.interfaces;

import edu.pasha.cursova.model.Coupe;

import java.util.List;

public interface ICoupeDao {
    Coupe save(Coupe coupe);
    Coupe get(String id);
    List<Coupe> getAll();
    Coupe edit(Coupe coupe);
    Coupe delete(String id);
}
