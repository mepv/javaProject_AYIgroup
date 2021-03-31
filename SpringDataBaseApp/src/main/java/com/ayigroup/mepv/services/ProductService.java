package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    void saveProduct(String productName, String condition, BigDecimal price);

    Product getProductById(long id);

    void deleteProductById(long id);

    List<Product> getProducts();
}
