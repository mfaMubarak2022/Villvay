package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Company;
import com.villvay.consumerservice.repo.CompanyRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRep companyRep;

    public List<Company> getAllCompanies() {
        return companyRep.findAll();
    }

    public long getTotalCompanies() {
        return companyRep.countByCompanyId();
    }

    public Company getCompanyDetails(int companyId) {

        return companyRep.findByCompanyId(companyId);
    }

}
