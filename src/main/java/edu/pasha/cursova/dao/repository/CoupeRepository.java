package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Coupe;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CoupeRepository extends MongoRepository<Coupe, String> {
}
