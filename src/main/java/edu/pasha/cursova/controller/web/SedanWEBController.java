package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.forms.SedanForm;
import edu.pasha.cursova.model.Sedan;
import edu.pasha.cursova.service.sedan.Impls.SedanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/sedan")
public class SedanWEBController {
    @Autowired
    SedanServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("sedan", service.getAll());
        return "SedanList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Sedan> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sedan", list);
        return "sedanList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Sedan> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sedan", list);
        return "sedanList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Sedan> list = service.sortByName();
        model.addAttribute("sedan", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "sedanList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Sedan> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("sedan", list);
        return "sedanList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        SedanForm sedanForm = new SedanForm();
        model.addAttribute("sedanForm", sedanForm);
        return "sedanAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("sedanForm") SedanForm sedanForm) {
        Sedan sedan = new Sedan();
        sedan.setModel(sedanForm.getModel());
        sedan.setBrand(sedanForm.getBrand());
        sedan.setProducingCountry(sedanForm.getProducingCountry());
        sedan.setGraduationYear(sedanForm.getGraduationYear());
        service.save(sedan);
        model.addAttribute("sedan", service.getAll());
        return "redirect:/web/sedan/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Sedan sedan = service.get(id);
        SedanForm sedanForm = new SedanForm();
        sedanForm.setModel(sedan.getModel());
        sedanForm.setBrand(sedan.getBrand());
        sedanForm.setProducingCountry(sedan.getProducingCountry());
        sedanForm.setGraduationYear(sedan.getGraduationYear());
        model.addAttribute("sedanForm", sedanForm);
        return "sedanAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("sedanForm") SedanForm sedanForm) {
        Sedan sedan = new Sedan();
        sedan.setId(id);
        sedan.setGraduationYear(sedanForm.getGraduationYear());
        sedan.setProducingCountry(sedanForm.getProducingCountry());
        sedan.setBrand(sedanForm.getBrand());
        sedan.setModel(sedanForm.getModel());
        service.save(sedan);
        model.addAttribute("sedan", service.getAll());
        return "redirect:/web/sedan/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("sedan", service.getAll());
        return "redirect:/web/sedan/list";
    }
}

