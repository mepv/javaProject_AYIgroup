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

    /**
     * Save a Product to the database.
     *
     * @param product the product object.
     */
    @Override
    public void saveProduct(Product product) {
        this.productRepository.save(product);
    }

    /**
     * Overload method to be implemented by the RestController class.
     * Save a Product to the database.
     *
     * @param productName the product name.
     * @param condition the condition.
     * @param price the price of the product.
     */
    @Override
    public void saveProduct(String productName, String condition, BigDecimal price) {
        Product tempProduct = new Product(productName, condition, price);
        saveProduct(tempProduct);
    }

    /**
     * Retrieve a specific product from the database.
     *
     * @param id the id of the product.
     *
     * @throws RuntimeException in case it was not found.
     *
     * @return the product object.
     */
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

    /**
     * Delete a Product from the database.
     *
     * @param id the id of the product.
     */
    @Override
    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }

    /**
     * Display all the Products from the database.
     *
     * @return a {@link java.util.List List<>} of products.
     */
    @Override
    public List<Product> getProducts() {
        return this.productRepository.findAll();
    }
}
