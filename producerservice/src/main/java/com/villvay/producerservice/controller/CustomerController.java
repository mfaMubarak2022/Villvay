package com.villvay.producerservice.controller;

import com.villvay.producerservice.entity.Customer;
import com.villvay.producerservice.model.CustomerResponse;
import com.villvay.producerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/getAllCustomers")
    public CustomerResponse getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/getCustomerDetails/{customerId}")
    public Customer getCustomerDetails(@PathVariable("customerId") int customerId) {

        return customerService.getCustomerDetails(customerId);
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {

        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody Customer customer) {

        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId) {

        return customerService.deleteCustomer(customerId);
    }
}
