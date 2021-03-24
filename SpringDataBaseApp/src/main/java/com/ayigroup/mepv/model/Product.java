package com.ayigroup.mepv.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "condition")
    private String condition;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "customer_id")
    private long customerId;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Customer> customers;

    public void addCustomer(Customer customer) {
        if (customers == null) {
            customers = new ArrayList<>();
        }
        customers.add(customer);
    }
}
