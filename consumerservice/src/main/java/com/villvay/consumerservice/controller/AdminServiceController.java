package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.User;
import com.villvay.consumerservice.model.UserDTO;
import com.villvay.consumerservice.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminServiceController {
    @Autowired
    AdminServiceImpl adminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getUser/{userName}")
    public User getUserData(@PathVariable("userName") String userName) {

        return adminService.getUserData(userName);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {

        return adminService.addUser(user);
    }

    @DeleteMapping("/deleteUser/{userName}")
    public int deleteUser(@PathVariable("userName") String userName) {

        return adminService.deleteUser(userName);
    }
}
