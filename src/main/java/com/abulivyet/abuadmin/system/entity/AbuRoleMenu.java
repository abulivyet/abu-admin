package com.abulivyet.abuadmin.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("abu_role_menu")
public class AbuRoleMenu {

    private long roleId;
    private long menuId;
}