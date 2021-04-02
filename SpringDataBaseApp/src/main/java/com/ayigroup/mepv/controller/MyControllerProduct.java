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
public class MyControllerProduct {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @GetMapping("/newProduct/{id}")
    public String newProduct(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("product", customerService.assignProducts(id));
        model.addAttribute("listProducts", productService.findAllProductsByCustomerId(id));
        return "new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        Customer tempCustomer = customerService.getCustomerById(product.getTempIdCustomer());
        product.addCustomer(tempCustomer);
        productService.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateProduct/{id}")
    public String showFormForUpdateProduct(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "update-product";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") long id) {
        this.productService.deleteProductById(id);
        return "redirect:/";
    }
}
