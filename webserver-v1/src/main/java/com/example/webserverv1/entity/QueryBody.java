package com.example.webserverv1.entity;

import lombok.Data;

@Data
public class QueryBody {
    private Integer pageSize;
    private Integer index;
    private String query;
    private Integer id;
//    public Query(Integer pageSize, Integer pageNum, Integer index){
//        this.pageNum = pageNum;
//        this.pageSize = pageSize;
//        this.index = index;
//    }
}
