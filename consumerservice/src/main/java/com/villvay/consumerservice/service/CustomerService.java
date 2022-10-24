package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getAllCustomers();

    public int getTotalCustomers();

    public Customer getCustomerDetails(int customerId);

    public Customer addCustomer(Customer customer);

    public Customer updateCustomer(Customer customer);

    public String deleteCustomer(int customerId);
}
