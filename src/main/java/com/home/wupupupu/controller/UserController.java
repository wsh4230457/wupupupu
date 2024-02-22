package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("register")
    public Result register(String username ,String password){


        if (userService.findUserByName(username)==null){
            userService.register(username,password);
            return Result.success();
        }
        return Result.error("注册失败,已有用户名");
    }
}
