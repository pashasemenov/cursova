package edu.pasha.cursova.service.technicalData.Impls;

import edu.pasha.cursova.dao.repository.TechnicalDataRepository;
import edu.pasha.cursova.dao.technicalData.impls.TechnicalDataDaoImplFake;
import edu.pasha.cursova.model.TechnicalData;
import edu.pasha.cursova.service.technicalData.Interfaces.ITechnicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicalDataServiceImpl implements ITechnicalDataService {
    @Autowired
    TechnicalDataDaoImplFake dao;

    @Autowired
    TechnicalDataRepository repository;

    @PostConstruct
    void init(){
        List<TechnicalData> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public TechnicalData save(TechnicalData technicalData) {
        return repository.save(technicalData);
    }

    @Override
    public TechnicalData get(String id) {
        return  repository.findById(id).orElse(null);
    }

    @Override
    public List<TechnicalData> getAll() {
        return repository.findAll();
    }

    @Override
    public TechnicalData edit(TechnicalData technicalData) {
        return repository.save(technicalData);
    }

    @Override
    public TechnicalData delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<TechnicalData> search(String word) {
        return this.getAll().stream()
                .filter(technicalData -> technicalData.getProductCode()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<TechnicalData> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(TechnicalData::getProductCode))
                .collect(Collectors.toList());
    }
}
