package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.CarBodyType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarBodyTypeRepository extends MongoRepository<CarBodyType, String> {
}
