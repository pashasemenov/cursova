package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Universal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversalRepository extends MongoRepository<Universal, String> {
}
