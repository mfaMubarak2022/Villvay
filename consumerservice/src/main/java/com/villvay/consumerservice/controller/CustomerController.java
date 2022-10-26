package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.service.CustomerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/getTotalCustomers")
    public long getTotalCustomers() {

        return customerService.getTotalCustomers();
    }

    @GetMapping("/getCustomerDetails/{customerId}")
    public Customer getCustomerDetails(@PathVariable("customerId") int customerId) {

        return customerService.getCustomerDetails(customerId);
    }


}
