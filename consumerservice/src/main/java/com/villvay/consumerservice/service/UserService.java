package com.villvay.consumerservice.service;

import com.villvay.consumerservice.repo.UserRep;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRep userRep;

    public UserService(UserRep userRep) {
        this.userRep = userRep;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        com.villvay.consumerservice.entity.User user = userRep.findByEmailId(username);
        if (user != null) {
            return new User(user.getEmailId(), user.getPassword(), new ArrayList<>());
        }

        return null;
    }
}
