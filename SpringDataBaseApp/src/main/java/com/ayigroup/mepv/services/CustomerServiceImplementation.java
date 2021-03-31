package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Customer;
import com.ayigroup.mepv.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImplementation implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Display all the Customers from the database.
     *
     * @return a {@link java.util.List List<>} of customers.
     */
    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Save a Customer to the database.
     *
     * @param customer the customer object.
     */
    @Override
    public void saveCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    /**
     * Overload method to be implemented by the RestController class.
     * Save a Customer to the database.
     *
     * @param firstName the first name.
     * @param lastName the last name.
     * @param email the email.
     */
    @Override
    public void saveCustomer(String firstName, String lastName, String email) {
        Customer tempCustomer = new Customer(firstName, lastName, email);
        saveCustomer(tempCustomer);
    }

    /**
     * Retrieve a specific Customer from the database.
     *
     * @param id the id of the customer.
     *
     * @throws RuntimeException in case it was not found.
     *
     * @return the customer object.
     */
    @Override
    public Customer getCustomerById(long id) {
        Optional<Customer> optional = customerRepository.findById(id);
        Customer customer;
        if (optional.isPresent()) {
            customer = optional.get();
        } else {
            throw new RuntimeException(" No hay data para id: " + id);
        }
        return customer;
    }

    /**
     * Delete a Customer from the database.
     *
     * @param id the id of the customer.
     */
    @Override
    public void deleteCustomerById(long id) {
        this.customerRepository.deleteById(id);
    }
}
