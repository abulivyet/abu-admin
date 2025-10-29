package com.abulivyet.abuadmin.system.service.Impl;

import com.abulivyet.abuadmin.system.entity.AbuRole;
import com.abulivyet.abuadmin.system.mapper.RoleMapper;
import com.abulivyet.abuadmin.system.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImppl extends ServiceImpl<RoleMapper, AbuRole> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;
}
