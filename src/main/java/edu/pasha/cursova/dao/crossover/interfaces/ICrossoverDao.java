package edu.pasha.cursova.dao.crossover.interfaces;

import edu.pasha.cursova.model.Crossover;

import java.util.List;

public interface ICrossoverDao {
    Crossover save(Crossover crossover);
    Crossover get(String id);
    List<Crossover> getAll();
    Crossover edit(Crossover crossover);
    Crossover delete(String id);
}
