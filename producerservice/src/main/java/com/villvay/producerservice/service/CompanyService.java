package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.Company;
import com.villvay.producerservice.model.CompanyResponse;

public interface CompanyService {
    public CompanyResponse getAllCompanies();

    public Company getCompanyDetails(int companyId);

    public Company addCompany(Company company);

    public Company updateCompany(Company company);

    public String deleteCompany(int companyId);
}
