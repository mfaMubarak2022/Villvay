package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.CompanyUser;
import com.villvay.producerservice.repo.CompanyUserRep;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final CompanyUserRep companyUserRep;

    private final PasswordEncoder passwordEncoder;

    public AdminServiceImpl(CompanyUserRep companyUserRep, PasswordEncoder passwordEncoder) {
        this.companyUserRep = companyUserRep;
        this.passwordEncoder = passwordEncoder;
    }

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
