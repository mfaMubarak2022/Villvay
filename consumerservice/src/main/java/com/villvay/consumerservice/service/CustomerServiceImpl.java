package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.repo.CustomerRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRep customerRep;

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
