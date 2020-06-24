package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Sedan;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SedanRepository extends MongoRepository<Sedan, String> {
}
