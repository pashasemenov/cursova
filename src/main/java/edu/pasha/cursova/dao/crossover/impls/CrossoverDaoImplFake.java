package edu.pasha.cursova.dao.crossover.impls;

import edu.pasha.cursova.dao.crossover.interfaces.ICrossoverDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Crossover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CrossoverDaoImplFake implements ICrossoverDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Crossover save(Crossover crossover) {
        return null;
    }

    @Override
    public Crossover get(String id) {
        return null;
    }

    @Override
    public List<Crossover> getAll() {
        return dataSet.getCrossover();
    }

    @Override
    public Crossover edit(Crossover crossover) {
        return null;
    }

    @Override
    public Crossover delete(String id) {
        return null;
    }
}
