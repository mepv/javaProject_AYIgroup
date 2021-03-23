package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomerById(long id);

    void deleteCustomerById(long id);
}
