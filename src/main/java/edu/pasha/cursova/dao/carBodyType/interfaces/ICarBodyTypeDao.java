package edu.pasha.cursova.dao.carBodyType.interfaces;

import edu.pasha.cursova.model.CarBodyType;

import java.util.List;

public interface ICarBodyTypeDao {
    CarBodyType save(CarBodyType carBodyType);
    CarBodyType get(String id);
    List<CarBodyType> getAll();
    CarBodyType edit(CarBodyType carBodyType);
    CarBodyType delete(String id);
}
