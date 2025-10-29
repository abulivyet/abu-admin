package com.abulivyet.abuadmin.system.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("abu_menu")
public class AbuMenu {

    @TableId(type = IdType.AUTO)
    private long menuId;
    private String menuName;
    private long parentId;
    private long orderNum;
    private String path;
    private String component;
    private String query;
    private String routeName;
    private long isFrame;
    private long isCache;
    private String menuType;
    private String visible;
    private String status;
    private String perms;
    private String icon;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;
    private String remark;
}