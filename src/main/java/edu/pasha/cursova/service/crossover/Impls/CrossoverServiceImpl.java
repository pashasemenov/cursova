package edu.pasha.cursova.service.crossover.Impls;

import edu.pasha.cursova.dao.crossover.impls.CrossoverDaoImplFake;
import edu.pasha.cursova.dao.repository.CrossoverRepository;
import edu.pasha.cursova.model.Crossover;
import edu.pasha.cursova.service.crossover.Interfaces.ICrossoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CrossoverServiceImpl implements ICrossoverService {
    @Autowired
    CrossoverDaoImplFake dao;

    @Autowired
    CrossoverRepository repository;

    @PostConstruct
    void init(){
        List<Crossover> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Crossover save(Crossover crossover) {
        return repository.save(crossover);
    }

    @Override
    public Crossover get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Crossover> getAll() {
        return repository.findAll();
    }

    @Override
    public Crossover edit(Crossover crossover) {
        return repository.save(crossover);
    }

    public List<Crossover> search(String word) {
        return this.getAll().stream()
                .filter(crossover -> crossover.getModel()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Crossover> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Crossover::getModel))
                .collect(Collectors.toList());
    }

    @Override
    public Crossover delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
