package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Product;
import com.ayigroup.mepv.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void saveProduct(String productName, String condition, BigDecimal price) {
        Product tempProduct = new Product(productName, condition, price);
        saveProduct(tempProduct);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product;
        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" No hay un producto especificado.");
        }
        return product;
    }

    @Override
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }
}
