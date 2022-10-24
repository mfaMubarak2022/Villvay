package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompanies();

    public int getTotalCompanies();

    public Company getCompanyDetails(int companyId);

    public Company addCompany(Company company);

    public Company updateCompany(Company company);

    public String deleteCompany(int companyId);
}
