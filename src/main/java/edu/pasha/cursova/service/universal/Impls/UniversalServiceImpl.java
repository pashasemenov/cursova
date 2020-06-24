package edu.pasha.cursova.service.universal.Impls;

import edu.pasha.cursova.dao.repository.UniversalRepository;
import edu.pasha.cursova.dao.universal.impls.UniversalDaoImplFake;
import edu.pasha.cursova.model.Universal;
import edu.pasha.cursova.service.universal.Interfaces.IUniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UniversalServiceImpl implements IUniversalService {
    @Autowired
    UniversalDaoImplFake dao;

    @Autowired
    UniversalRepository repository;

    @PostConstruct
    void init(){
        List<Universal> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Universal save(Universal universal) {
        return repository.save(universal);
    }

    @Override
    public Universal get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Universal> getAll() {
        return repository.findAll();
    }

    @Override
    public Universal edit(Universal universal) {
        return repository.save(universal);
    }

    @Override
    public Universal delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Universal> search(String word) {
        return this.getAll().stream()
                .filter(universal -> universal.getModel()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Universal> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Universal::getModel))
                .collect(Collectors.toList());
    }
}
