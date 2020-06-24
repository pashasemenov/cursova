package edu.pasha.cursova.service.cabriolet.Impls;

import edu.pasha.cursova.dao.cabriolet.impls.CabrioletDaoImplFake;
import edu.pasha.cursova.dao.repository.CabrioletRepository;
import edu.pasha.cursova.model.Cabriolet;
import edu.pasha.cursova.service.cabriolet.Interfaces.ICabrioletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CabrioletServiceImpl implements ICabrioletService {
    @Autowired
    CabrioletDaoImplFake dao;

    @Autowired
    CabrioletRepository repository;

    @PostConstruct
    void init(){
        List<Cabriolet> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Cabriolet save(Cabriolet cabriolet) {
        return repository.save(cabriolet);
    }

    @Override
    public Cabriolet get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Cabriolet> getAll() {
        return repository.findAll();
    }

    @Override
    public Cabriolet edit(Cabriolet cabriolet) {
        return repository.save(cabriolet);
    }

    public List<Cabriolet> search(String word) {
        return this.getAll().stream()
                .filter(cabriolet -> cabriolet.getModel()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Cabriolet delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }


    public List<Cabriolet> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Cabriolet::getModel))
                .collect(Collectors.toList());
    }
}
