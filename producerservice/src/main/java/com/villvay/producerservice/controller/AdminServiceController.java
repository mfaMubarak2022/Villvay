package com.villvay.producerservice.controller;

import com.villvay.producerservice.entity.CompanyUser;
import com.villvay.producerservice.model.CompanyUserDTO;
import com.villvay.producerservice.service.AdminServiceImpl;
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
    public CompanyUser getUserData(@PathVariable("userName") String userName) {

        return adminService.getUserData(userName);
    }

    @PostMapping("/addUser")
    public CompanyUser addUser(@RequestBody CompanyUser companyUser) {

        return adminService.addUser(companyUser);
    }

    @DeleteMapping("/deleteUser/{userName}")
    public int deleteUser(@PathVariable("userName") String userName) {

        return adminService.deleteUser(userName);
    }
}
