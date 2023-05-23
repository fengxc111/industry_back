package com.example.webserverv1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.webserverv1.entity.QueryBody;
import com.example.webserverv1.entity.Worker;
import com.example.webserverv1.mapper.WorkerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WorkerController {

    @Autowired
    private WorkerMapper workerMapper;

    @PostMapping("/workerinfo")
    public Map deviceinfo(@RequestBody QueryBody queryBody){
        System.out.println(queryBody);
//        return "获取设备信息成功";
        String query = queryBody.getQuery().trim();
        Page<Worker> page = new Page<>(queryBody.getIndex(), queryBody.getPageSize());
        Map<String, Object> map = new HashMap<>();
        Page<Worker> pageResult = workerMapper.selectPage(page, new QueryWrapper<Worker>().like(StringUtils.isNotEmpty(query),"workerName", query));
        map.put("list", pageResult.getRecords());
        map.put("total", pageResult.getTotal());
        return map;
    }
}
