package com.villvay.consumerservice.model;

import com.villvay.consumerservice.entity.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponse {

    private List<Company> companyList;
}
