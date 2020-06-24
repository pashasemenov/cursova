package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.EmployeesForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Employees;
import edu.pasha.cursova.service.employees.impls.EmployeesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/employees")
public class EmployeesWEBController {
    @Autowired
    EmployeesServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("employees", service.getAll());
        return "employeesList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Employees> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("employees", list);
        return "employeesList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Employees> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("employees", list);
        return "employeesList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Employees> list = service.sortByName();
        model.addAttribute("employees", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "employeesList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Employees> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("employees", list);
        return "employeesList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        EmployeesForm employeesForm = new EmployeesForm();
        model.addAttribute("employeesForm", employeesForm);
        return "employeesAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("coupeForm") EmployeesForm employeesForm) {
        Employees employees = new Employees();
        employees.setSurname(employeesForm.getSurname());
        employees.setName(employeesForm.getName());
        employees.setPatronymic(employeesForm.getPatronymic());
        employees.setPosition(employeesForm.getPosition());
        employees.setAddress(employeesForm.getAddress());
        employees.setPhone(employeesForm.getPhone());
        service.save(employees);
        model.addAttribute("employees", service.getAll());
        return "redirect:/web/employees/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Employees employees = service.get(id);
        EmployeesForm employeesForm = new EmployeesForm();
        employeesForm.setSurname(employees.getSurname());
        employeesForm.setName(employees.getName());
        employeesForm.setPatronymic(employees.getPatronymic());
        employeesForm.setPosition(employees.getPosition());
        employeesForm.setAddress(employees.getAddress());
        employeesForm.setPhone(employees.getPhone());
        model.addAttribute("employeesForm", employeesForm);
        return "employeesAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("employeesForm") EmployeesForm employeesForm) {
        Employees employees = new Employees();
        employees.setId(id);
        employees.setPhone(employeesForm.getPhone());
        employees.setAddress(employeesForm.getAddress());
        employees.setPosition(employeesForm.getPosition());
        employees.setPatronymic(employeesForm.getPatronymic());
        employees.setName(employeesForm.getName());
        employees.setSurname(employeesForm.getSurname());
        service.save(employees);
        model.addAttribute("employees", service.getAll());
        return "redirect:/web/employees/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("employees", service.getAll());
        return "redirect:/web/employees/list";
    }
}

