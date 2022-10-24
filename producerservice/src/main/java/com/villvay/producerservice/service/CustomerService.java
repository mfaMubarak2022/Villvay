package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.Customer;
import com.villvay.producerservice.model.CustomerResponse;

public interface CustomerService {
    public CustomerResponse getAllCustomers();

    public Customer getCustomerDetails(int customerId);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public String deleteCustomer(int customerId);
}
