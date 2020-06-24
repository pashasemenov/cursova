package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Purchase;
import edu.pasha.cursova.service.purchase.Impls.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseAPIController {
    @Autowired
    PurchaseServiceImpl service;

    @RequestMapping("/list")
    List<Purchase> getAll() {
        return service.getAll();
    }

}
