package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Cabriolet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CabrioletRepository extends MongoRepository<Cabriolet, String> {
}
