package com.abulivyet.abuadmin.system.service;

import com.abulivyet.abuadmin.system.dto.RegisterDTO;
import com.abulivyet.abuadmin.system.entity.AbuUser;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<AbuUser> {

    void register(RegisterDTO registerDTO);

}

