package com.example.webserverv1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {

    @TableId
    private Integer userId;

    private String userName;

    private String password;

    @TableField(select = false)
    private String newpw;
}
