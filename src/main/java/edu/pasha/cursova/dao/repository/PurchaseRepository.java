package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Purchase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PurchaseRepository extends MongoRepository<Purchase, String> {
}
