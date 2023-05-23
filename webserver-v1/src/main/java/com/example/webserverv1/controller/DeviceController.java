package com.example.webserverv1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.webserverv1.entity.Device;
import com.example.webserverv1.entity.QueryBody;
import com.example.webserverv1.mapper.DeviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeviceController {

    @Autowired
    private DeviceMapper deviceMapper;

    @PostMapping("/deviceinfo")
    public Map deviceinfo(@RequestBody QueryBody queryBody){
        System.out.println(queryBody);
//        return "获取设备信息成功";
        String query = queryBody.getQuery().trim();
        Page<Device> page = new Page<>(queryBody.getIndex(), queryBody.getPageSize());
        Map<String, Object> map = new HashMap<>();
        Page<Device> pageResult = deviceMapper.selectPage(page, new QueryWrapper<Device>().like(StringUtils.isNotEmpty(query),"deviceName", query));
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return map;
    }

    @PostMapping("/changestatus")
    public Integer changestatus(@RequestBody QueryBody queryBody){
        System.out.println(queryBody);
//        return "修改设备状态成功";
        String query = queryBody.getQuery();
        Integer id = queryBody.getId();
        Device device = deviceMapper.selectById(id);
        device.setStatus(query);
        Integer ret = deviceMapper.updateById(device);
//        if(ret != 0){
//            System.out.println("修改失败");
//        }else{
//            System.out.println("修改成功");
//        }
        return ret;
    }
}
