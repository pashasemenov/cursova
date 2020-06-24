package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Crossover;
import edu.pasha.cursova.service.crossover.Impls.CrossoverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/crossover")
public class CrossoverAPIController{
    @Autowired
    CrossoverServiceImpl service;

    @RequestMapping("/list")
    List<Crossover> getAll() {
        return service.getAll();
    }

}

