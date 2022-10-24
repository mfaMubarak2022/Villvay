package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.model.CustomerDTO;
import com.villvay.consumerservice.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @GetMapping("/getAllCustomers")
    public List<Customer> getAllCustomers() {

        return customerService.getAllCustomers();
    }

    @GetMapping("/getTotalCustomers")
    public int getTotalCustomers() {

        return customerService.getTotalCustomers();
    }

    @GetMapping("/getCustomerDetails/{customerId}")
    public Customer getCustomerDetails(@PathVariable("customerId") int customerId) {

        return customerService.getCustomerDetails(customerId);
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody CustomerDTO customer) {

        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestBody CustomerDTO customer) {

        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("/deleteCustomer/{customerId}")
    public String deleteCustomer(@PathVariable("customerId") int customerId) {

        return customerService.deleteCustomer(customerId);
    }
}
