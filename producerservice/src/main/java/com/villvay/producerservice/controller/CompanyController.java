package com.villvay.producerservice.controller;

import com.villvay.producerservice.entity.Company;
import com.villvay.producerservice.model.CompanyResponse;
import com.villvay.producerservice.service.CompanyServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyServiceImpl companyService;

    public CompanyController(CompanyServiceImpl companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/getAllCompanies")
    public CompanyResponse getAllCompanies() {

        return companyService.getAllCompanies();
    }

    @GetMapping("/getCompanyDetails/{companyId}")
    public Company getCompanyDetails(@PathVariable("companyId") int companyId) {

        return companyService.getCompanyDetails(companyId);
    }

    @PostMapping("/addCompany")
    public Company addCompany(@RequestBody Company company) {

        return companyService.addCompany(company);
    }

    @PutMapping("/updateCompany")
    public Company updateCompany(@RequestBody Company company) {

        return companyService.updateCompany(company);
    }

    @DeleteMapping("/deleteCompany/{companyId}")
    public String deleteCompany(@PathVariable("companyId") int companyId) {

        return companyService.deleteCompany(companyId);
    }
}
