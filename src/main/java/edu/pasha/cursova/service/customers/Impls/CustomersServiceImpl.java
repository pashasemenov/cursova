package edu.pasha.cursova.service.customers.Impls;

import edu.pasha.cursova.dao.customers.impls.CustomersDaoImplFake;
import edu.pasha.cursova.dao.repository.CustomersRepository;
import edu.pasha.cursova.model.Customers;
import edu.pasha.cursova.service.customers.Interfaces.ICustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersServiceImpl implements ICustomersService {
    @Autowired
    CustomersDaoImplFake dao;

    @Autowired
    CustomersRepository repository;

    @PostConstruct
    void init(){
        List<Customers> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Customers save(Customers customers) {
        return repository.save(customers);
    }

    @Override
    public Customers get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customers> getAll() {
        return repository.findAll();
    }

    @Override
    public Customers edit(Customers customers) {
        return repository.save(customers);
    }

    public List<Customers> search(String word) {
        return this.getAll().stream()
                .filter(customers -> customers.getClientsName()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Customers> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Customers::getClientsName))
                .collect(Collectors.toList());
    }

    @Override
    public Customers delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
