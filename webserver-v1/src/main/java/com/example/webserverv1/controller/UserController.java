package com.example.webserverv1.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.webserverv1.entity.User;
import com.example.webserverv1.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public String user(){
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
        return "查询用户";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        System.out.println(user);
        if(user == null) {
            return "请输入用户名和密码";
        }
        if(user.getUserName() == null) {
            return "用户名不能为空";
        }
        if(user.getPassword() == null) {
            return "密码不能为空";
        }

//        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("userName", user.getUserName()));
        User userResult = userMapper.selectOne(new QueryWrapper<User>().eq("userName", user.getUserName()));
        if(userResult == null){
            return "该用户不存在";
        }
        if(!userResult.getPassword().equals(user.getPassword())){
            return "用户名或密码错误";
        }

        return "登录成功";
    }

    @PostMapping("/changepw")
    public String changepw(@RequestBody User user){
        System.out.println(user);
        User userResult = userMapper.selectOne(new QueryWrapper<User>().eq("userName", user.getUserName()));
        if(userResult == null){
            return "该用户不存在";
        }
        if(!userResult.getPassword().equals(user.getPassword())){
            return "旧密码错误";
        }

        userResult.setPassword(user.getNewpw());
        userResult.setUserName(user.getUserName());
        userMapper.update(userResult, new QueryWrapper<User>().eq("userName", user.getUserName()));
        userResult = userMapper.selectOne(new QueryWrapper<User>().eq("userName", user.getUserName()));
        System.out.println(userResult);
        return "修改成功";
    }
}
