package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Company;
import com.villvay.consumerservice.service.CompanyServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/getTotalCompanies")
    public long getTotalCompanies() {

        return companyService.getTotalCompanies();
    }

    @GetMapping("/getCompanyDetails/{companyId}")
    public Company getCompanyDetails(@PathVariable("companyId") int companyId) {

        return companyService.getCompanyDetails(companyId);
    }


}
