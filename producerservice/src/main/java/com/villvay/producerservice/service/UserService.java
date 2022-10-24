package com.villvay.producerservice.service;

import com.villvay.producerservice.entity.CompanyUser;
import com.villvay.producerservice.repo.CompanyUserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    CompanyUserRep companyUserRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        CompanyUser user = companyUserRep.findByUserName(username);
        if (user != null) {
            return new User(user.getUserName() + " " + user.getId(), user.getPassword(), new ArrayList<>());
        }

        return null;
    }
}
