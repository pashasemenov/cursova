package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.forms.UniversalForm;
import edu.pasha.cursova.model.Universal;
import edu.pasha.cursova.service.universal.Impls.UniversalServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/universal")
public class UniversalWEBController {
    @Autowired
    UniversalServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("universal", service.getAll());
        return "UniversalList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Universal> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("universal", list);
        return "universalList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Universal> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("universal", list);
        return "universalList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Universal> list = service.sortByName();
        model.addAttribute("universal", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "universalList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Universal> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("universal", list);
        return "universalList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        UniversalForm universalForm = new UniversalForm();
        model.addAttribute("universalForm", universalForm);
        return "universalAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("universalForm") UniversalForm universalForm) {
        Universal universal = new Universal();
        universal.setModel(universalForm.getModel());
        universal.setBrand(universalForm.getBrand());
        universal.setProducingCountry(universalForm.getProducingCountry());
        universal.setGraduationYear(universalForm.getGraduationYear());
        service.save(universal);
        model.addAttribute("universal", service.getAll());
        return "redirect:/web/universal/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Universal universal = service.get(id);
        UniversalForm universalForm = new UniversalForm();
        universalForm.setModel(universal.getModel());
        universalForm.setBrand(universal.getBrand());
        universalForm.setProducingCountry(universal.getProducingCountry());
        universalForm.setGraduationYear(universal.getGraduationYear());
        model.addAttribute("universalForm", universalForm);
        return "universalAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("universalForm") UniversalForm universalForm) {
        Universal universal = new Universal();
        universal.setId(id);
        universal.setGraduationYear(universalForm.getGraduationYear());
        universal.setProducingCountry(universalForm.getProducingCountry());
        universal.setBrand(universalForm.getBrand());
        universal.setModel(universalForm.getModel());
        service.save(universal);
        model.addAttribute("universal", service.getAll());
        return "redirect:/web/universal/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("universal", service.getAll());
        return "redirect:/web/universal/list";
    }
}

