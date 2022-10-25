package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public int getTotalCustomers();

    public Customer getCustomerDetails(int customerId);
    
}
