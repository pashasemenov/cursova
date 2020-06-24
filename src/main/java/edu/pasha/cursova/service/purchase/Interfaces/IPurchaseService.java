package edu.pasha.cursova.service.purchase.Interfaces;

import edu.pasha.cursova.model.Purchase;

import java.util.List;

public interface IPurchaseService {
    Purchase save(Purchase purchase);
    Purchase get(String id);
    List<Purchase> getAll();
    Purchase edit(Purchase purchase);
    Purchase delete(String id);
}
