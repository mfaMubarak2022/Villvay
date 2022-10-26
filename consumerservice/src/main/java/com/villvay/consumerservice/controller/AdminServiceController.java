package com.villvay.consumerservice.controller;

import com.villvay.consumerservice.entity.User;
import com.villvay.consumerservice.service.AdminServiceImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdminServiceController {
    private final AdminServiceImpl adminService;

    private final PasswordEncoder passwordEncoder;

    public AdminServiceController(AdminServiceImpl adminService, PasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }

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
