package edu.pasha.cursova.service.purchase.Impls;

import edu.pasha.cursova.dao.purchase.impls.PurchaseDaoImplFake;
import edu.pasha.cursova.dao.repository.PurchaseRepository;
import edu.pasha.cursova.model.Purchase;
import edu.pasha.cursova.service.purchase.Interfaces.IPurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseServiceImpl implements IPurchaseService {
    @Autowired
    PurchaseDaoImplFake dao;

    @Autowired
    PurchaseRepository repository;

    @PostConstruct
    void init(){
        List<Purchase> list = dao.getAll();

        repository.saveAll(list);
    }

    @Override
    public Purchase save(Purchase purchase) {
        return repository.save(purchase);
    }

    @Override
    public Purchase get(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Purchase> getAll() {
        return repository.findAll();
    }

    @Override
    public Purchase edit(Purchase purchase) {
        return repository.save(purchase);
    }

    public List<Purchase> search(String word) {
        return this.getAll().stream()
                .filter(purchase -> purchase.getProductCode()
                        .toLowerCase().contains(word.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Purchase> sortByName() {
        return this.getAll().stream().sorted(Comparator.comparing(Purchase::getProductCode))
                .collect(Collectors.toList());
    }
    @Override
    public Purchase delete(String id) {
        repository.deleteById(id);
        return repository.findById(id).orElse(null);
    }
}
