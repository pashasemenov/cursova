package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Crossover;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CrossoverRepository extends MongoRepository<Crossover, String> {
}