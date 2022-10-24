package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.CompanyUser;

public interface AdminService {
    public CompanyUser getUserData(String userName);

    public CompanyUser addUser(CompanyUser companyUser);

    public int deleteUser(String userName);
}
