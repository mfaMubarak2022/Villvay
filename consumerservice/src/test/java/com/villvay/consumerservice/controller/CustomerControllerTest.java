package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.model.CustomerDTO;
import com.villvay.consumerservice.service.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerControllerTest {

    static List<Customer> mockCustomersList = new ArrayList<>();
    static Customer mockCustomer = new Customer();
    static CustomerDTO mockCustomerDTO = new CustomerDTO();
    @Mock
    CustomerServiceImpl customerService;
    @InjectMocks
    CustomerController customerController;

    @BeforeAll
    static void beforeEach() {
        mockCustomer.setCustomerId(1);
        mockCustomer.setCustomerName("Saman");

        mockCustomerDTO.setCustomerId(1);
        mockCustomerDTO.setCustomerName("Saman");
        mockCustomersList.add(mockCustomer);
    }

    @Test
    void getAllCustomers() {

        Mockito.when(customerService.getAllCustomers()).thenReturn(mockCustomersList);
        assertEquals(customerController.getAllCustomers(), customerService.getAllCustomers());
    }

    @Test
    void getTotalCustomers() {
        Mockito.when(customerService.getTotalCustomers()).thenReturn(10);
        assertEquals(customerController.getTotalCustomers(), customerService.getTotalCustomers());
    }

    @Test
    void getCustomerDetails() {

        Mockito.when(customerService.getCustomerDetails(1)).thenReturn(mockCustomer);
        assertEquals(customerController.getCustomerDetails(1), customerService.getCustomerDetails(1));
    }

    @Test
    void addCustomer() {

        Mockito.when(customerService.addCustomer(mockCustomerDTO)).thenReturn(mockCustomer);
        assertEquals(customerController.addCustomer(mockCustomerDTO), customerService.addCustomer(mockCustomerDTO));
    }

    @Test
    void updateCustomer() {
        Mockito.when(customerService.updateCustomer(mockCustomerDTO)).thenReturn(mockCustomer);
        assertEquals(customerController.updateCustomer(mockCustomerDTO), customerService.updateCustomer(mockCustomerDTO));
    }

    @Test
    void deleteCustomer() {

        Mockito.when(customerService.deleteCustomer(1)).thenReturn("Success");
        assertEquals(customerController.deleteCustomer(1), customerService.deleteCustomer(1));

    }
}