package edu.pasha.cursova.dao.purchase.interfaces;

import edu.pasha.cursova.model.Purchase;

import java.util.List;

public interface IPurchaseDao {
    Purchase save(Purchase purchase);
    Purchase get(String id);
    List<Purchase> getAll();
    Purchase edit(Purchase purchase);
    Purchase delete(String id);
}
