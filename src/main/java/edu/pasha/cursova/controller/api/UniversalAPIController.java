package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Universal;
import edu.pasha.cursova.service.universal.Impls.UniversalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/universal")
public class UniversalAPIController{
    @Autowired
    UniversalServiceImpl service;

    @RequestMapping("/list")
    List<Universal> getAll() {
        return service.getAll();
    }

}