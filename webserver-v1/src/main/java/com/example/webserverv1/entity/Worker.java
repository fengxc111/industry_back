package com.example.webserverv1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Worker {

    @TableId
    private Integer workerId;

    private String workerName;

    private String tel;

    private String department;

    private String addr;
}
