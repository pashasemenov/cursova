package edu.pasha.cursova.controller.api;

import edu.pasha.cursova.model.Coupe;
import edu.pasha.cursova.service.coupe.Impls.CoupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupe")
public class CoupeAPIController{
    @Autowired
    CoupeServiceImpl service;

    @RequestMapping("/list")
    List<Coupe> getAll() {
        return service.getAll();
    }

    @RequestMapping("/{id}")
    Coupe getById(@PathVariable("id") String id) {
        return service.get(id);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Coupe create(@RequestBody Coupe coupe) {
        return service.save(coupe);
    }

    @RequestMapping("/delete/{id}")
    Coupe delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
