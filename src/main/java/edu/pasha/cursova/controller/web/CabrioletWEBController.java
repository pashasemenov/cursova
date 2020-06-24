package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.CabrioletForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Cabriolet;
import edu.pasha.cursova.service.cabriolet.Impls.CabrioletServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/web/cabriolet")
public class CabrioletWEBController {
    @Autowired
    CabrioletServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("cabriolet", service.getAll());
        return "CabrioletList";
    }
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Cabriolet> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("cabriolet", list);
        return "cabrioletList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Cabriolet> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("cabriolet", list);
        return "cabrioletList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Cabriolet> list = service.sortByName();
        model.addAttribute("cabriolet", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "cabrioletList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Cabriolet> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("cabriolet", list);
        return "cabrioletList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CabrioletForm cabrioletForm = new CabrioletForm();
        model.addAttribute("cabrioletForm", cabrioletForm);
        return "cabrioletAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("cabrioletForm") CabrioletForm cabrioletForm) {
        Cabriolet cabriolet = new Cabriolet();
        cabriolet.setModel(cabrioletForm.getModel());
        cabriolet.setBrand(cabrioletForm.getBrand());
        cabriolet.setProducingCountry(cabrioletForm.getProducingCountry());
        cabriolet.setGraduationYear(cabrioletForm.getGraduationYear());
        service.save(cabriolet);
        model.addAttribute("cabriolet", service.getAll());
        return "redirect:/web/cabriolet/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Cabriolet cabriolet = service.get(id);
        CabrioletForm cabrioletForm = new CabrioletForm();
        cabrioletForm.setModel(cabriolet.getModel());
        cabrioletForm.setBrand(cabriolet.getBrand());
        cabrioletForm.setProducingCountry(cabriolet.getProducingCountry());
        cabrioletForm.setGraduationYear(cabriolet.getGraduationYear());
        model.addAttribute("cabrioletForm", cabrioletForm);
        return "cabrioletAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("cabrioletForm") CabrioletForm cabrioletForm) {
        Cabriolet cabriolet = new Cabriolet();
        cabriolet.setId(id);
        cabriolet.setGraduationYear(cabrioletForm.getGraduationYear());
        cabriolet.setProducingCountry(cabrioletForm.getProducingCountry());
        cabriolet.setBrand(cabrioletForm.getBrand());
        cabriolet.setModel(cabrioletForm.getModel());
        service.save(cabriolet);
        model.addAttribute("coupe", service.getAll());
        return "redirect:/web/coupe/list";
    }


    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("cabriolet", service.getAll());
        return "redirect:/web/cabriolet/list";
    }
}

