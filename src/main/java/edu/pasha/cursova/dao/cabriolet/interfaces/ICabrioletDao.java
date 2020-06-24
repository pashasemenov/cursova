package edu.pasha.cursova.dao.cabriolet.interfaces;

import edu.pasha.cursova.model.Cabriolet;

import java.util.List;

public interface ICabrioletDao {
    Cabriolet save(Cabriolet cabriolet);
    Cabriolet get(String id);
    List<Cabriolet> getAll();
    Cabriolet edit(Cabriolet cabriolet);
    Cabriolet delete(String id);
}
