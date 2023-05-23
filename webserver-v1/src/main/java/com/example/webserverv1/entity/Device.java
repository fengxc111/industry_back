package com.example.webserverv1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Device {

    @TableId
    private Integer deviceId;

    private String deviceName;

    private String location;

    private String departmentName;

    private String status;

    private String latestTime;
}
