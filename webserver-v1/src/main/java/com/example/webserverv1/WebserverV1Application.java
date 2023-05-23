package com.example.webserverv1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.webserverv1.mapper")
public class WebserverV1Application {

	public static void main(String[] args) {
		SpringApplication.run(WebserverV1Application.class, args);
	}

}
