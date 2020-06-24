package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Customers;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomersRepository extends MongoRepository<Customers, String> {
}