package com.abulivyet.abuadmin.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("abu-user_role")
public class AbuUserRole {

    private long userId;
    private long roleId;
}
