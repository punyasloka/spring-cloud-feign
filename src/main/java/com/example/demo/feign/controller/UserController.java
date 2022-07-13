package com.example.demo.feign.controller;

import com.example.demo.feign.client.UserClient;
import com.example.demo.feign.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableFeignClients(basePackageClasses = {UserClient.class})
public class UserController {

    @Autowired
    UserClient userClient;

    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return userClient.getUsers();
    }
}
