package com.abulivyet.abuadmin.system.service.Impl;

import com.abulivyet.abuadmin.system.dto.RegisterDTO;
import com.abulivyet.abuadmin.system.entity.AbuUser;
import com.abulivyet.abuadmin.system.mapper.UserMapper;
import com.abulivyet.abuadmin.system.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, AbuUser> implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterDTO registerDTO) {
        //判断用户是否存在
        AbuUser existing = userMapper.selectByUsername(registerDTO.getUsername());
        if (existing != null) {
            throw new RuntimeException("用户名已存在");
        }
        //密码加密
        String encodePassword = passwordEncoder.encode(registerDTO.getPassword());
        //保存
        AbuUser abuUser = new AbuUser();
        abuUser.setUsername(registerDTO.getUsername());
        abuUser.setPassword(encodePassword);
        abuUser.setStatus(1);
        abuUser.setCreateTime(LocalDateTime.now());
        userMapper.insert(abuUser);
    }
}
