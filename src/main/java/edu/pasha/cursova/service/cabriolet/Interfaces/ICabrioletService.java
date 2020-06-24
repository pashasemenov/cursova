package edu.pasha.cursova.service.cabriolet.Interfaces;

import edu.pasha.cursova.model.Cabriolet;

import java.util.List;

public interface ICabrioletService {
    Cabriolet save(Cabriolet cabriolet);
    Cabriolet get(String id);
    List<Cabriolet> getAll();
    Cabriolet edit(Cabriolet cabriolet);
    Cabriolet delete(String id);
}
