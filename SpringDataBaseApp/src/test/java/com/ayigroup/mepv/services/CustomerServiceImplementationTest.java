package com.ayigroup.mepv.services;

import com.ayigroup.mepv.model.Customer;
import com.ayigroup.mepv.repositories.CustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@DataJpaTest
class CustomerServiceImplementationTest {

    @Mock
    private CustomerRepository customerRepository;
    private AutoCloseable autoCloseable;
    private CustomerService underTestCustomerService;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTestCustomerService = new CustomerServiceImplementation(customerRepository);
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void getCustomers() {
        underTestCustomerService.getCustomers();
        verify(customerRepository).findAll();
    }

    @Test
    void saveCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Mario");
        customer.setLastName("Palacios");
        underTestCustomerService.saveCustomer(customer);

        ArgumentCaptor<Customer> customerArgumentCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(customerRepository).saveAndFlush(customerArgumentCaptor.capture());
        Customer capturedCustomer = customerArgumentCaptor.getValue();

        assertThat(capturedCustomer).isEqualTo(customer);
    }

    @Test
    void testSaveCustomer() {
    }

    @Test
    void getCustomerById() {
        long id = 1;
        Customer customer = new Customer("Mario", "Palacios", "mario@email.com");
        customerRepository.save(customer);

        Customer exists = underTestCustomerService.getCustomerById(id);

        assertThat(exists).isEqualTo(customer);
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void assignProducts() {
    }
}