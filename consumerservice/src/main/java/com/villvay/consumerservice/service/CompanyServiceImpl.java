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

    public int getTotalCompanies() {
        return companyRep.findAll().size();
    }

    public Company getCompanyDetails(int companyId) {

        return companyRep.findByCompanyId(companyId);
    }

    public Company addCompany(Company company) {

        return companyRep.save(company);
    }

    public Company updateCompany(Company company) {


        return companyRep.save(company);
    }

    public String deleteCompany(int companyId) {

        return companyRep.deleteByCompanyId(companyId) > 0 ? "Success" : "Failed";
    }
}
