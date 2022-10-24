package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.User;
import com.villvay.consumerservice.repo.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserRep userRep;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User getUserData(String userName) {

        return userRep.findByEmailId(userName);
    }

    public User addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userRep.save(user);
    }

    public int deleteUser(String userName) {

        return userRep.deleteByEmailId(userName);
    }
}
