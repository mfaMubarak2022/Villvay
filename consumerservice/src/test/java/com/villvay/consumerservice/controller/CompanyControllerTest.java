package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.Company;
import com.villvay.consumerservice.model.CompanyDTO;
import com.villvay.consumerservice.service.CompanyServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CompanyControllerTest {
    static List<Company> mockCompanyList = new ArrayList<>();
    static Company mockCompany = new Company();
    static CompanyDTO mockCompanyDTO = new CompanyDTO();
    @Mock
    CompanyServiceImpl companyService;
    @InjectMocks
    CompanyController companyController;

    @BeforeAll
    static void setUp() {
        mockCompany.setCompanyId(1);
        mockCompany.setCompanyName("Villvay");

        mockCompanyDTO.setCompanyId(1);
        mockCompanyDTO.setCompanyName("Villvay");
        mockCompanyList.add(mockCompany);
    }

    @Test
    void getAllCompanies() {
        Mockito.when(companyService.getAllCompanies()).thenReturn(mockCompanyList);
        assertEquals(companyController.getAllCompanies(), companyService.getAllCompanies());
    }

    @Test
    void getTotalCompanies() {
        Mockito.when(companyService.getTotalCompanies()).thenReturn(10L);
        assertEquals(companyController.getTotalCompanies(), companyService.getTotalCompanies());
    }

    @Test
    void getCompanyDetails() {

        Mockito.when(companyService.getCompanyDetails(1)).thenReturn(mockCompany);
        assertEquals(companyController.getCompanyDetails(1), companyService.getCompanyDetails(1));

    }

}