package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Product;

import java.util.List;

public interface ProductService {

    void saveProduct(Product product);

    Product getProductById(long id);

    void deleteProductById(long id);

    List<Product> getProducts();

}
