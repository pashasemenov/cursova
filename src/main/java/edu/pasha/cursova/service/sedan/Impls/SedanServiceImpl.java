package edu.pasha.cursova.service.sedan.Impls;

import edu.pasha.cursova.dao.repository.SedanRepository;
import edu.pasha.cursova.dao.sedan.impls.SedanDaoImplFake;
import edu.pasha.cursova.model.Sedan;
import edu.pasha.cursova.service.sedan.Interfaces.ISedanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SedanServiceImpl implements ISedanService {
    @Autowired
    SedanDaoImplFake dao;

    @Autowired
    SedanRepository repository;

    @PostConstruct
    void init(){
        List<Sedan> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Sedan save(Sedan sedan) {
        return repository.save(sedan);
    }

    @Override
    public Sedan get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Sedan> getAll() {
        return repository.findAll();
    }

    @Override
    public Sedan edit(Sedan sedan) {
        return repository.save(sedan);
    }

    @Override
    public Sedan delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Sedan> search(String word) {
        return this.getAll().stream()
                .filter(sedan -> sedan.getModel()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Sedan> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Sedan::getModel))
                .collect(Collectors.toList());
    }
}
