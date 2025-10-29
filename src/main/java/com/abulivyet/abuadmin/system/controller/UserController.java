package com.abulivyet.abuadmin.system.controller;

import com.abulivyet.abuadmin.common.annotation.Log;
import com.abulivyet.abuadmin.common.response.ApiResponse;
import com.abulivyet.abuadmin.system.dto.RegisterDTO;
import com.abulivyet.abuadmin.system.entity.AbuUser;
import com.abulivyet.abuadmin.system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Log
    @GetMapping("/list")
    public ApiResponse<List<AbuUser>> list() {
        List<AbuUser> list = userService.list();
        return ApiResponse.success(list);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody AbuUser user) {
        return userService.save(user);
    }

    @PostMapping("/register")
    public ApiResponse<Void> register(@Valid @RequestBody RegisterDTO  registerDTO) {
        userService.register(registerDTO);
        return ApiResponse.success();
    }

    @GetMapping("/test")
    public ApiResponse<Void> test(){

        return ApiResponse.success();
    }
}

