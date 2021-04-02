package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface ProductService {

    void saveProduct(Product product);

    void saveProduct(String productName, String condition, BigDecimal price);

    Product getProductById(long id);

    void deleteProductById(long id);

    List<Product> getAllProducts();

    Set<Product> findAllProductsByCustomerId(long id);
}
