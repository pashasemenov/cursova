package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.CoupeForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Coupe;
import edu.pasha.cursova.service.coupe.Impls.CoupeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/coupe")
public class CoupeWEBController {
    @Autowired
    CoupeServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("coupe", service.getAll());
        return "CoupeList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Coupe> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coupe", list);
        return "coupeList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Coupe> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coupe", list);
        return "coupeList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Coupe> list = service.sortByName();
        model.addAttribute("coupe", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "coupeList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Coupe> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("coupe", list);
        return "coupeList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CoupeForm coupeForm = new CoupeForm();
        model.addAttribute("coupeForm", coupeForm);
        return "coupeAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("coupeForm") CoupeForm coupeForm) {
        Coupe coupe = new Coupe();
        coupe.setModel(coupeForm.getModel());
        coupe.setBrand(coupeForm.getBrand());
        coupe.setProducingCountry(coupeForm.getProducingCountry());
        coupe.setGraduationYear(coupeForm.getGraduationYear());
        service.save(coupe);
        model.addAttribute("coupe", service.getAll());
        return "redirect:/web/coupe/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Coupe coupe = service.get(id);
        CoupeForm coupeForm = new CoupeForm();
        coupeForm.setModel(coupe.getModel());
        coupeForm.setBrand(coupe.getBrand());
        coupeForm.setProducingCountry(coupe.getProducingCountry());
        coupeForm.setGraduationYear(coupe.getGraduationYear());
        model.addAttribute("coupeForm", coupeForm);
        return "coupeAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("coupeForm") CoupeForm coupeForm) {
        Coupe coupe = new Coupe();
        coupe.setId(id);
        coupe.setGraduationYear(coupeForm.getGraduationYear());
        coupe.setProducingCountry(coupeForm.getProducingCountry());
        coupe.setBrand(coupeForm.getBrand());
        coupe.setModel(coupeForm.getModel());
        service.save(coupe);
        model.addAttribute("coupe", service.getAll());
        return "redirect:/web/coupe/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("coupe", service.getAll());
        return "redirect:/web/coupe/list";
    }
}
