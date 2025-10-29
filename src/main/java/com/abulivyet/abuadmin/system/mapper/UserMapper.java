package com.abulivyet.abuadmin.system.mapper;

import com.abulivyet.abuadmin.system.entity.AbuUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<AbuUser> {

    @Select("select * from `abu-admin`.`abu_user` where username = #{username}")
    AbuUser selectByUsername (String username);
}
