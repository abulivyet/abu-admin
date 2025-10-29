package com.abulivyet.abuadmin.system.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("abu_user")
public class AbuUser {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;
    private String realname;
    private String password;
    private String avatar;
    private String birthday;
    private int sex;
    private String email;
    private String phone;
    private int status;
    private int delFlag;
    private String createby;
    private LocalDateTime createTime;
    private String updateby;
    private LocalDateTime updateTime;
    private String departIds;
    private String mainDepPostId;
    private String positionType;


}
