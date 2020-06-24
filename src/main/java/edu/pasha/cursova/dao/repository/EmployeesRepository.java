package edu.pasha.cursova.dao.repository;

import edu.pasha.cursova.model.Employees;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeesRepository extends MongoRepository<Employees, String> {
}
