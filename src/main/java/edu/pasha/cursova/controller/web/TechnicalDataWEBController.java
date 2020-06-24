package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.forms.TechnicalDataForm;
import edu.pasha.cursova.model.TechnicalData;
import edu.pasha.cursova.service.technicalData.Impls.TechnicalDataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/technicalData")
public class TechnicalDataWEBController {
    @Autowired
    TechnicalDataServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("technicalData", service.getAll());
        return "technicalDataList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<TechnicalData> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technicalData", list);
        return "technicalDataList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnicalData> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technicalData", list);
        return "technicalDataList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<TechnicalData> list = service.sortByName();
        model.addAttribute("technicalData", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "technicalDataList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<TechnicalData> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("technicalData", list);
        return "technicalDataList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        TechnicalDataForm technicalDataForm = new TechnicalDataForm();
        model.addAttribute("technicalDataForm", technicalDataForm);
        return "technicalDataAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("technicalDataForm") TechnicalDataForm technicalDataForm) {
        TechnicalData technicalData = new TechnicalData();
        technicalData.setProductCode(technicalDataForm.getProductCode());
        technicalData.setBodyType(technicalDataForm.getBodyType());
        technicalData.setNumberOfDoors(technicalDataForm.getNumberOfDoors());
        technicalData.setNumberOfSeats(technicalDataForm.getNumberOfSeats());
        technicalData.setEngineType(technicalDataForm.getEngineType());
        technicalData.setLocationOfTheEngine(technicalDataForm.getLocationOfTheEngine());
        technicalData.setEngineDisplacement(technicalDataForm.getEngineDisplacement());
        service.save(technicalData);
        model.addAttribute("technicalData", service.getAll());
        return "redirect:/web/technicalData/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        TechnicalData technicalData = service.get(id);
        TechnicalDataForm technicalDataForm = new TechnicalDataForm();
        technicalDataForm.setProductCode(technicalData.getProductCode());
        technicalDataForm.setBodyType(technicalData.getBodyType());
        technicalDataForm.setNumberOfDoors(technicalData.getNumberOfDoors());
        technicalDataForm.setNumberOfSeats(technicalData.getNumberOfSeats());
        technicalDataForm.setEngineType(technicalData.getEngineType());
        technicalDataForm.setLocationOfTheEngine(technicalData.getLocationOfTheEngine());
        technicalDataForm.setEngineDisplacement(technicalData.getEngineDisplacement());
        model.addAttribute("technicalDataForm", technicalDataForm);
        return "technicalDataAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("technicalDataForm") TechnicalDataForm technicalDataForm) {
        TechnicalData technicalData = new TechnicalData();
        technicalData.setId(id);
        technicalData.setEngineDisplacement(technicalDataForm.getEngineDisplacement());
        technicalData.setLocationOfTheEngine(technicalDataForm.getLocationOfTheEngine());
        technicalData.setEngineType(technicalDataForm.getEngineType());
        technicalData.setNumberOfSeats(technicalDataForm.getNumberOfSeats());
        technicalData.setNumberOfDoors(technicalDataForm.getNumberOfDoors());
        technicalData.setBodyType(technicalDataForm.getBodyType());
        technicalData.setProductCode(technicalDataForm.getProductCode());
        service.save(technicalData);
        model.addAttribute("technicalData", service.getAll());
        return "redirect:/web/technicalData/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("technicalData", service.getAll());
        return "redirect:/web/technicalData/list";
    }
}
