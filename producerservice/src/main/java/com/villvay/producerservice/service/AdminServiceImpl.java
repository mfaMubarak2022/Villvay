package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.CompanyUser;
import com.villvay.producerservice.repo.CompanyUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    CompanyUserRep companyUserRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CompanyUser getUserData(String userName) {

        return companyUserRep.findByUserName(userName);
    }

    public CompanyUser addUser(CompanyUser companyUser) {

        companyUser.setPassword(passwordEncoder.encode(companyUser.getPassword()));

        return companyUserRep.save(companyUser);
    }

    public int deleteUser(String userName) {

        return companyUserRep.deleteByUserName(userName);
    }
}
