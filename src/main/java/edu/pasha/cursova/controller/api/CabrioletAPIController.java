package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Cabriolet;
import edu.pasha.cursova.service.cabriolet.Impls.CabrioletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cabriolet")
public class CabrioletAPIController{
    @Autowired
    CabrioletServiceImpl service;

    @RequestMapping("/list")
    List<Cabriolet> getAll() {
        return service.getAll();
    }
}

