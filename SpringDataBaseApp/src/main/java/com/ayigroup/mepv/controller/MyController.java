package com.ayigroup.mepv.controller;

import com.ayigroup.mepv.model.Customer;
import com.ayigroup.mepv.model.Product;
import com.ayigroup.mepv.services.CustomerService;
import com.ayigroup.mepv.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("listCustomer", customerService.getCustomers());
        return "index";
    }

    @GetMapping("/newCustomer")
    public String newCustomer(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "new-customer";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable (value = "id") long id) {
        this.customerService.deleteCustomerById(id);
        return "redirect:/";
    }

    @GetMapping("/newProduct")
    public String newProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("listProducts", productService.getProducts());
        return "new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/deleteProduct/{id}")
    private String deleteProduct(@PathVariable (value = "id") long id) {
        this.productService.deleteProductById(id);
        return "redirect:/";
    }
}