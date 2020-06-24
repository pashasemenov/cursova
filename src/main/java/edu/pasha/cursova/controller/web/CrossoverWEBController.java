package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.CrossoverForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Crossover;
import edu.pasha.cursova.service.crossover.Impls.CrossoverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/crossover")
public class CrossoverWEBController {
    @Autowired
    CrossoverServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("crossover", service.getAll());
        return "CrossoverList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Crossover> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("crossover", list);
        return "crossoverList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Crossover> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("crossover", list);
        return "crossoverList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Crossover> list = service.sortByName();
        model.addAttribute("crossover", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "crossoverList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Crossover> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("crossover", list);
        return "crossoverList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CrossoverForm crossoverForm = new CrossoverForm();
        model.addAttribute("crossoverForm", crossoverForm);
        return "crossoverAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("coupeForm") CrossoverForm crossoverForm) {
        Crossover crossover = new Crossover();
        crossover.setModel(crossoverForm.getModel());
        crossover.setBrand(crossoverForm.getBrand());
        crossover.setProducingCountry(crossoverForm.getProducingCountry());
        crossover.setGraduationYear(crossoverForm.getGraduationYear());
        service.save(crossover);
        model.addAttribute("crossover", service.getAll());
        return "redirect:/web/crossover/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Crossover crossover = service.get(id);
        CrossoverForm crossoverForm = new CrossoverForm();
        crossoverForm.setModel(crossover.getModel());
        crossoverForm.setBrand(crossover.getBrand());
        crossoverForm.setProducingCountry(crossover.getProducingCountry());
        crossoverForm.setGraduationYear(crossover.getGraduationYear());
        model.addAttribute("crossoverForm", crossoverForm);
        return "crossoverAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("coupeForm") CrossoverForm crossoverForm) {
        Crossover crossover = new Crossover();
        crossover.setId(id);
        crossover.setGraduationYear(crossoverForm.getGraduationYear());
        crossover.setProducingCountry(crossoverForm.getProducingCountry());
        crossover.setBrand(crossoverForm.getBrand());
        crossover.setModel(crossoverForm.getModel());
        service.save(crossover);
        model.addAttribute("coupe", service.getAll());
        return "redirect:/web/coupe/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("crossover", service.getAll());
        return "redirect:/web/crossover/list";
    }
}
