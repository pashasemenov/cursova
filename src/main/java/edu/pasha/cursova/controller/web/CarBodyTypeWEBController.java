package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.CarBodyTypeForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.CarBodyType;
import edu.pasha.cursova.service.carBodyType.Impls.CarBodyTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/carBodyType")
public class CarBodyTypeWEBController {
    @Autowired
    CarBodyTypeServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("carBodyType", service.getAll());
        return "CarBodyTypeList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<CarBodyType> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carBodyType", list);
        return "carBodyTypeList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<CarBodyType> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carBodyType", list);
        return "carBodyTypeList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<CarBodyType> list = service.sortByName();
        model.addAttribute("carBodyType", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "carBodyTypeList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<CarBodyType> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("carBodyType", list);
        return "carBodyTypeList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CarBodyTypeForm carBodyTypeForm = new CarBodyTypeForm();
        model.addAttribute("carBodyTypeForm", carBodyTypeForm);
        return "carBodyTypeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("carBodyTypeForm") CarBodyTypeForm carBodyTypeForm) {
        CarBodyType carBodyType = new CarBodyType();
        carBodyType.setType(carBodyTypeForm.getType());
        carBodyType.setProducer(carBodyTypeForm.getProducer());
        service.save(carBodyType);
        model.addAttribute("carBodyType", service.getAll());
        return "redirect:/web/carBodyType/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        CarBodyType carBodyType = service.get(id);
        CarBodyTypeForm carBodyTypeForm = new CarBodyTypeForm();
        carBodyTypeForm.setType(carBodyType.getType());
        carBodyTypeForm.setProducer(carBodyType.getProducer());
        model.addAttribute("carBodyTypeForm", carBodyTypeForm);
        return "carBodyTypeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("carBodyTypeForm") CarBodyTypeForm carBodyTypeForm) {
        CarBodyType carBodyType = new CarBodyType();
        carBodyType.setId(id);
        carBodyType.setProducer(carBodyTypeForm.getProducer());
        carBodyType.setType(carBodyTypeForm.getType());
        service.save(carBodyType);
        model.addAttribute("carBodyType", service.getAll());
        return "redirect:/web/carBodyType/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("carBodyType", service.getAll());
        return "redirect:/web/carBodyType/list";
    }
}

