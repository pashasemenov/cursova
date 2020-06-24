package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Sedan;
import edu.pasha.cursova.service.sedan.Impls.SedanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sedan")
public class SedanAPIController{
    @Autowired
    SedanServiceImpl service;

    @RequestMapping("/list")
    List<Sedan> getAll() {
        return service.getAll();
    }
}
