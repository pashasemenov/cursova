package edu.pasha.cursova.service.crossover.Interfaces;

import edu.pasha.cursova.model.Crossover;

import java.util.List;

public interface ICrossoverService {
    Crossover save(Crossover crossover);
    Crossover get(String id);
    List<Crossover> getAll();
    Crossover edit(Crossover crossover);
    Crossover delete(String id);
}
