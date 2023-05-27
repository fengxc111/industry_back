package com.example.webserverv1.entity;

import lombok.Data;

@Data
public class QueryBody {
    private Integer pageSize;
    private Integer index;
    private String query;
    private Integer id;
}
