package edu.pasha.cursova.dao.carBodyType.impls;

import edu.pasha.cursova.dao.carBodyType.interfaces.ICarBodyTypeDao;
import edu.pasha.cursova.dataSet.DataSet;
import edu.pasha.cursova.model.CarBodyType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarBodyTypeDaoImplFake implements ICarBodyTypeDao {

    @Autowired
    DataSet dataSet;

    @Override
    public CarBodyType save(CarBodyType carBodyType) {
        return null;
    }

    @Override
    public CarBodyType get(String id) {
        return null;
    }

    @Override
    public List<CarBodyType> getAll() {
        return dataSet.getCarBodyType();
    }

    @Override
    public CarBodyType edit(CarBodyType carBodyType) {
        return null;
    }

    @Override
    public CarBodyType delete(String id) {
        return null;
    }
}
