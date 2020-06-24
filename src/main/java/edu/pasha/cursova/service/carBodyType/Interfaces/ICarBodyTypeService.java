package edu.pasha.cursova.service.carBodyType.Interfaces;

import edu.pasha.cursova.model.CarBodyType;

import java.util.List;

public interface ICarBodyTypeService {
    CarBodyType save(CarBodyType cabriolet);
    CarBodyType get(String id);
    List<CarBodyType> getAll();
    CarBodyType edit(CarBodyType cabriolet);
    CarBodyType delete(String id);
}

