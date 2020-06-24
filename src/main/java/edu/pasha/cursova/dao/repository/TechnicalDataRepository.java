package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.TechnicalData;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TechnicalDataRepository extends MongoRepository<TechnicalData, String> {
}
