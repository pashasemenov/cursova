package edu.pasha.cursova.service.coupe.Impls;

import edu.pasha.cursova.dao.coupe.impls.CoupeDaoImplFake;
import edu.pasha.cursova.dao.repository.CoupeRepository;
import edu.pasha.cursova.model.Coupe;
import edu.pasha.cursova.service.coupe.Interfaces.ICoupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoupeServiceImpl implements ICoupeService {
    @Autowired
    CoupeDaoImplFake dao;

    @Autowired
    CoupeRepository repository;

    @PostConstruct
    void init(){
        List<Coupe> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Coupe save(Coupe coupe) {
        return repository.save(coupe);
    }

    @Override
    public Coupe get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Coupe> getAll() {
        return repository.findAll();
    }

    @Override
    public Coupe edit(Coupe coupe) {
        return repository.save(coupe);
    }

    @Override
    public Coupe delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Coupe> search(String word) {
        return this.getAll().stream()
                .filter(coupe -> coupe.getModel()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Coupe> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Coupe::getModel))
                .collect(Collectors.toList());
    }
}
