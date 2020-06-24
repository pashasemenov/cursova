package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.TechnicalData;
import edu.pasha.cursova.service.technicalData.Impls.TechnicalDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/technicalData")
public class TechnicalDataAPIController{
    @Autowired
    TechnicalDataServiceImpl service;

    @RequestMapping("/list")
    List<TechnicalData> getAll() {
        return service.getAll();
    }

}

