package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.Customer;
import com.villvay.producerservice.model.CustomerResponse;
import com.villvay.producerservice.repo.CustomerRep;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRep customerRep;

    public CustomerServiceImpl(CustomerRep customerRep) {
        this.customerRep = customerRep;
    }

    public CustomerResponse getAllCustomers() {

        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCustomerList(customerRep.findAll());
        return customerResponse;
    }

    public Customer getCustomerDetails(int customerId) {

        return customerRep.findByCustomerId(customerId);
    }

    public Customer addCustomer(Customer customer) {

        return customerRep.save(customer);
    }

    public Customer updateCustomer(Customer customer) {

        return customerRep.save(customer);
    }

    public String deleteCustomer(int customerId) {

        return customerRep.deleteByCustomerId(customerId) > 0 ? "Success" : "Failed";
    }
}
