package edu.pasha.cursova.service.carBodyType.Impls;

import edu.pasha.cursova.dao.carBodyType.impls.CarBodyTypeDaoImplFake;
import edu.pasha.cursova.dao.repository.CarBodyTypeRepository;
import edu.pasha.cursova.model.CarBodyType;
import edu.pasha.cursova.service.carBodyType.Interfaces.ICarBodyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarBodyTypeServiceImpl implements ICarBodyTypeService {
    @Autowired
    CarBodyTypeDaoImplFake dao;

    @Autowired
    CarBodyTypeRepository repository;

    @PostConstruct
    void init(){
        List<CarBodyType> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public CarBodyType save(CarBodyType carBodyType) {
        return repository.save(carBodyType);
    }

    @Override
    public CarBodyType get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<CarBodyType> getAll() {
        return repository.findAll();
    }

    @Override
    public CarBodyType edit(CarBodyType carBodyType) {
        return repository.save(carBodyType);
    }

    @Override
    public CarBodyType delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<CarBodyType> search(String word) {
        return this.getAll().stream()
                .filter(carBodyType -> carBodyType.getProducer()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<CarBodyType> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(CarBodyType::getProducer))
                .collect(Collectors.toList());
    }
}
