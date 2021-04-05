package com.ayigroup.mepv.controller;

import com.ayigroup.mepv.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class MyControllerCustomerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private CustomerService customerServiceMock;

    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void homePageTest() throws Exception {
        assertThat(this.customerServiceMock).isNotNull();
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(view().name("index"));
    }



//
//
//    Customer customer;
//    @Before
//    public void setUpCustomer() throws Exception {
//        customer = new Customer();
//        customer.setId(1);
//        customer.setFirstName("Mario");
//        customer.setLastName("Palacios");
//        customer.setEmail("mario@email.com");
//    }
//
//    @Test
//    void showFormForUpdateTest() throws Exception {
//        assertThat(this.customerServiceMock).isNotNull();
//        Mockito.when(customerServiceMock.getCustomerById(1)).thenReturn(customer);
//
//        MvcResult result = mockMvc.perform(get("/showFormForUpdate/{id}", 1))
//                .andExpect(status().isOk())
//                .andExpect(view().name("new-customer"))
//                .andExpect(model().attributeExists("customer"))
//                .andExpect(model().attribute("customer", hasProperty("id", is(1L))))
//                .andExpect(model().attribute("customer", hasProperty("firstName", is("Mario"))))
//                .andExpect(model().attribute("customer", hasProperty("lastName", is("Palacios"))))
//                .andExpect(model().attribute("customer", hasProperty("email", is("mario@email.com"))))
//                .andReturn();
//        MockHttpServletResponse mockHttpServletResponse = result.getResponse();
//        assertThat(mockHttpServletResponse.getContentType()).isEqualTo("text/html;charset=UTF-8");
//
//        verify(customerServiceMock, times(1)).getCustomerById(1);
//        verifyNoMoreInteractions(customerServiceMock);
//    }
}