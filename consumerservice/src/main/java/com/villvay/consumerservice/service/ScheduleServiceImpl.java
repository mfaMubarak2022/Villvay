package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Company;
import com.villvay.consumerservice.entity.Customer;
import com.villvay.consumerservice.model.CompanyResponse;
import com.villvay.consumerservice.model.CustomerResponse;
import com.villvay.consumerservice.model.JwtRequest;
import com.villvay.consumerservice.model.JwtResponse;
import com.villvay.consumerservice.repo.CompanyRep;
import com.villvay.consumerservice.repo.CustomerRep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class ScheduleServiceImpl implements ScheduleService {
    private final CustomerRep customerRep;
    private final CompanyRep companyRep;
    private final RestTemplate restTemplate;

    @Value("${company.username}")
    private String username;

    @Value("${company.password}")
    private String password;

    public ScheduleServiceImpl(CustomerRep customerRep, CompanyRep companyRep, RestTemplate restTemplate) {
        this.customerRep = customerRep;
        this.companyRep = companyRep;
        this.restTemplate = restTemplate;
    }


    @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 1000)
    public void getAllCustomerAndCompanyDetails() {
        log.info("Company Table Sync Started");
        JwtRequest jwtRequest = new JwtRequest();
        jwtRequest.setUsername(username);
        jwtRequest.setPassword(password);

        CompanyResponse companyResponse = new CompanyResponse();
        CustomerResponse customerResponse = new CustomerResponse();
        JwtResponse jwtResponse = restTemplate.exchange("http://localhost:8044/user/authentication", HttpMethod.POST, new HttpEntity<>(jwtRequest), JwtResponse.class).getBody();
        if (null != jwtResponse) {

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("content-type", MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.set("Accept", MediaType.APPLICATION_JSON_VALUE);
            httpHeaders.set("Authorization", "PToken " + jwtResponse.getJwtToken());
            companyResponse = restTemplate.exchange("http://localhost:8044/company/getAllCompanies", HttpMethod.GET, new HttpEntity<>(httpHeaders), CompanyResponse.class).getBody();

            customerResponse = restTemplate.exchange("http://localhost:8044/customer/getAllCustomers", HttpMethod.GET, new HttpEntity<>(httpHeaders), CustomerResponse.class).getBody();

        }
        if (null != companyResponse) {
            List<Company> companyList = companyResponse.getCompanyList();
            companyRep.saveAll(companyList);
            log.info("Company Sync Completed");
        }
        if (null != customerResponse) {
            List<Customer> customersList = customerResponse.getCustomerList();
            customerRep.saveAll(customersList);
            log.info("Customer Sync Completed");
        }
    }


}
