package com.example.webserverv1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Department {

    @TableId
    private Integer departmentId;

    private String departmentName;
}
