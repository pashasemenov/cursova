package edu.pasha.cursova.dao.purchase.impls;

import edu.pasha.cursova.dao.purchase.interfaces.IPurchaseDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PurchaseDaoImplFake implements IPurchaseDao {

    @Autowired
    DataSet dataSet;

    @Override
    public Purchase save(Purchase purchase ) {
        return null;
    }

    @Override
    public Purchase get(String id) {
        return null;
    }

    @Override
    public List<Purchase> getAll() {
        return dataSet.getPurchase();
    }

    @Override
    public Purchase edit(Purchase purchase) {
        return null;
    }

    @Override
    public Purchase delete(String id) {
        return null;
    }
}

