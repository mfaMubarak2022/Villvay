package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.Company;
import com.villvay.producerservice.model.CompanyResponse;
import com.villvay.producerservice.repo.CompanyRep;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRep companyRep;

    public CompanyServiceImpl(CompanyRep companyRep) {
        this.companyRep = companyRep;
    }

    public CompanyResponse getAllCompanies() {
        CompanyResponse companyResponse = new CompanyResponse();

        companyResponse.setCompanyList(companyRep.findAll());

        return companyResponse;
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
