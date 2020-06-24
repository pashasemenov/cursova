package edu.pasha.cursova.service.employees.impls;

import edu.pasha.cursova.dao.employees.impls.EmployeesDaoImplFake;
import edu.pasha.cursova.dao.repository.EmployeesRepository;
import edu.pasha.cursova.model.Employees;
import edu.pasha.cursova.service.employees.interfaces.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeesServiceImpl implements IEmployeesService {
    @Autowired
    EmployeesDaoImplFake dao;

    @Autowired
    EmployeesRepository repository;

    @PostConstruct
    void init(){
        List<Employees> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Employees save(Employees employees) {
        return repository.save(employees);
    }

    @Override
    public Employees get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Employees> getAll() {
        return repository.findAll();
    }

    @Override
    public Employees edit(Employees employees) {
        return repository.save(employees);
    }

    @Override
    public Employees delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }

    public List<Employees> search(String word) {
        return this.getAll().stream()
                .filter(employees -> employees.getSurname()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Employees> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Employees::getSurname))
                .collect(Collectors.toList());
    }
}
