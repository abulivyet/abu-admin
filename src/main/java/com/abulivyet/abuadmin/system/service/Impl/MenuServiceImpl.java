package com.abulivyet.abuadmin.system.service.Impl;


import com.abulivyet.abuadmin.system.entity.AbuMenu;
import com.abulivyet.abuadmin.system.mapper.MenuMapper;
import com.abulivyet.abuadmin.system.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, AbuMenu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

}
