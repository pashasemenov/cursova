package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.CustomersForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Customers;
import edu.pasha.cursova.service.customers.Impls.CustomersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/customers")
public class CustomersWEBController {
    @Autowired
    CustomersServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("customers", service.getAll());
        return "customersList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Customers> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", list);
        return "customersList";
    }

    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Customers> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", list);
        return "customersList";
    }


    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model) {
        List<Customers> list = service.sortByName();
        model.addAttribute("customers", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "customersList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Customers> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("customers", list);
        return "customersList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        CustomersForm customersForm = new CustomersForm();
        model.addAttribute("customersForm", customersForm);
        return "customersAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("coupeForm") CustomersForm customersForm) {
        Customers customers = new Customers();
        customers.setClientsName(customersForm.getClientsName());
        customers.setPassportData(customersForm.getPassportData());
        customers.setHomeAddress(customersForm.getHomeAddress());
        customers.setPhone(customersForm.getPhone());
        service.save(customers);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customers/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Customers customers = service.get(id);
        CustomersForm customersForm = new CustomersForm();
        customersForm.setClientsName(customers.getClientsName());
        customersForm.setPassportData(customers.getPassportData());
        customersForm.setHomeAddress(customers.getHomeAddress());
        customersForm.setPhone(customers.getPhone());
        model.addAttribute("customersForm", customersForm);
        return "customersAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("customersForm") CustomersForm customersForm) {
        Customers customers = new Customers();
        customers.setId(id);
        customers.setPhone(customersForm.getPhone());
        customers.setHomeAddress(customersForm.getHomeAddress());
        customers.setPassportData(customersForm.getPassportData());
        customers.setClientsName(customersForm.getClientsName());
        service.save(customers);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customers/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("customers", service.getAll());
        return "redirect:/web/customers/list";
    }
}
