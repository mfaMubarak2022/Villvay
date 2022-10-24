package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Company;
import com.villvay.consumerservice.model.CompanyDTO;
import com.villvay.consumerservice.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/getAllCompanies")
    public List<Company> getAllCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/getTotalCompanies")
    public int getTotalCompanies() {

        return companyService.getTotalCompanies();
    }

    @GetMapping("/getCompanyDetails/{companyId}")
    public Company getCompanyDetails(@PathVariable("companyId") int companyId) {

        return companyService.getCompanyDetails(companyId);
    }

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody CompanyDTO company) {

        return companyService.addCompany(company);
    }

    @PutMapping("/updateCompany")
    public Company updateCompany(@RequestBody CompanyDTO company) {

        return companyService.updateCompany(company);
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    public String deleteCompany(@PathVariable("companyId") int companyId) {

        return companyService.deleteCompany(companyId);
    }
}
