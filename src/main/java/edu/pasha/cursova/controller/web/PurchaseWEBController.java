package edu.pasha.cursova.controller.web;

import edu.pasha.cursova.forms.PurchaseForm;
import edu.pasha.cursova.forms.SearchForm;
import edu.pasha.cursova.model.Purchase;
import edu.pasha.cursova.service.purchase.Impls.PurchaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/web/purchase")
public class PurchaseWEBController {
    @Autowired
    PurchaseServiceImpl service;

    @RequestMapping("/list")
    String getAll(Model model) {
        model.addAttribute("purchase", service.getAll());
        return "PurchaseList";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Purchase> list = service.getAll();
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("purchase", list);
        return "purchaseList";
    }
    @PostMapping(value = "/list")
    public String search(Model model,
                         @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Purchase> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("purchase", list);
        return "purchaseList";
    }



    @RequestMapping(value = "/list/sorted", method = RequestMethod.GET)
    String sort(Model model){
        List<Purchase> list = service.sortByName();
        model.addAttribute("purchase", list);
        SearchForm searchForm = new SearchForm();
        model.addAttribute("searchForm", searchForm);
        return "purchaseList";
    }

    @RequestMapping(value = "/list/sorted", method = RequestMethod.POST)
    public String searchSorted(Model model,
                               @ModelAttribute("searchForm") SearchForm searchForm) {
        String word = searchForm.getString();
        List<Purchase> list = service.search(word);
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("purchase", list);
        return "purchaseList";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    String create(Model model) {
        PurchaseForm purchaseForm = new PurchaseForm();
        model.addAttribute("purchaseForm", purchaseForm);
        return "purchaseAdd";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute("purchaseForm") PurchaseForm purchaseForm) {
        Purchase purchase = new Purchase();
        purchase.setProductCode(purchaseForm.getProductCode());
        purchase.setClientCode(purchaseForm.getClientCode());
        purchase.setDate(purchaseForm.getDate());
        purchase.setDelivery(purchaseForm.getDelivery());
        purchase.setTypeOfPayment(purchaseForm.getTypeOfPayment());
        service.save(purchase);
        model.addAttribute("purchase", service.getAll());
        return "redirect:/web/purchase/list";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    String edit(Model model, @PathVariable("id") String id) {
        Purchase purchase = service.get(id);
        PurchaseForm purchaseForm = new PurchaseForm();
        purchaseForm.setProductCode(purchase.getProductCode());
        purchaseForm.setClientCode(purchase.getClientCode());
        purchaseForm.setDate(purchase.getDate());
        purchaseForm.setDelivery(purchase.getDelivery());
        purchaseForm.setTypeOfPayment(purchase.getTypeOfPayment());
        model.addAttribute("purchaseForm", purchaseForm);
        return "purchaseAdd";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    String edit(Model model, @PathVariable("id") String id, @ModelAttribute("coupeForm") PurchaseForm purchaseForm) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setTypeOfPayment(purchaseForm.getTypeOfPayment());
        purchase.setDelivery(purchaseForm.getDelivery());
        purchase.setDate(purchaseForm.getDate());
        purchase.setClientCode(purchaseForm.getClientCode());
        purchase.setProductCode(purchaseForm.getProductCode());
        service.save(purchase);
        model.addAttribute("purchase", service.getAll());
        return "redirect:/web/purchase/list";
    }

    @RequestMapping("/delete/{id}")
    String delete(Model model,
                  @PathVariable("id") String id) {
        service.delete(id);
        model.addAttribute("purchase", service.getAll());
        return "redirect:/web/purchase/list";
    }
}
