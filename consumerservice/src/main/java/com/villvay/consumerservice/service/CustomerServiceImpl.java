package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.repo.CustomerRep;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRep customerRep;

    public CustomerServiceImpl(CustomerRep customerRep) {
        this.customerRep = customerRep;
    }

    public List<Customer> getAllCustomers() {
        return customerRep.findAll();
    }

    public long getTotalCustomers() {
        return customerRep.countByCustomerId();
    }

    public Customer getCustomerDetails(int customerId) {

        return customerRep.findByCustomerId(customerId);
    }


}
