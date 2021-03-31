package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    void saveCustomer(String firstName, String lastName, String email);

    Customer getCustomerById(long id);

    void deleteCustomerById(long id);
}
