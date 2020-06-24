package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.CarBodyType;
import edu.pasha.cursova.service.carBodyType.Impls.CarBodyTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/carBodyType")
public class CarBodyTypeAPIController{
    @Autowired
    CarBodyTypeServiceImpl service;

    @RequestMapping("/list")
    List<CarBodyType> getAll() {
        return service.getAll();
    }
}