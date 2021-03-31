package com.ayigroup.mepv.controller;

import com.ayigroup.mepv.model.InitElementCustomer;
import com.ayigroup.mepv.model.InitElementProduct;
import com.ayigroup.mepv.services.CustomerService;
import com.ayigroup.mepv.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class MyRestController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/newProducts")
    public String newProducts(@RequestParam(name = "product", defaultValue = "producto sin nombre") String productName,
                              @RequestParam(name = "condition", defaultValue = "sin definir") String condition,
                              @RequestParam(name = "price", defaultValue = "0") BigDecimal price,
                              @RequestBody InitElementProduct initElementProduct) {
        productService.saveProduct(initElementProduct.getProductName(),
                initElementProduct.getCondition(),
                initElementProduct.getPrice());
        return "";
    }

    @PostMapping("/newCustomers")
    public String newCustomers(@RequestParam(name = "firstName", defaultValue = "anonimo") String firstName,
                               @RequestParam(name = "lastName", defaultValue = "anonimo") String lastName,
                               @RequestParam(name = "email", defaultValue = "example@email.com") String email,
                               @RequestBody InitElementCustomer initElementCustomer) {
        customerService.saveCustomer(initElementCustomer.getFirstName(),
                initElementCustomer.getLastName(),
                initElementCustomer.getEmail());
        return "";
    }
}

