package com.villvay.consumerservice.service;

import com.villvay.consumerservice.entity.User;

public interface AdminService {
    public User getUserData(String userName);

    public User addUser(User user);

    public int deleteUser(String userName);
}
