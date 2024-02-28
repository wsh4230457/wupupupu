package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.pojo.User;
import com.home.wupupupu.service.UserService;
import com.home.wupupupu.util.JWTUtil;
import com.home.wupupupu.util.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("register")
    public Result register(@Pattern(regexp = "^\\S{5,20}$") String username , @Pattern(regexp = "^\\S{6,32}$") String password){
        if (userService.findUserByName(username)==null){
            userService.register(username,password);
            return Result.success();
        }
        return Result.error("注册失败,已有用户名");
    }
    @GetMapping("login")
    public Result login(@Pattern(regexp = "^\\S{5,20}$") String username , @Pattern(regexp = "^\\S{6,32}$") String password){
        User user=userService.findUserByName(username);
        if (user==null){
            return Result.error("用户名不存在");
        }
        if (!password.equals(user.getPassword())){
            return Result.error("密码错误");
        }
        Map<String,Object> claims=new HashMap<>();
        claims.put("username",user.getUsername());
        claims.put("id",user.getId());
        String claim= JWTUtil.getToken(claims);
        return Result.success(claim);
    }
    @GetMapping("findUser")
    public Result<User> getUserInfo(){
        Map<String,Object> claims=ThreadLocalUtil.get();

        String username= (String) claims.get("username");

        User user=userService.findUserByName(username);
        return Result.success(user);
    }
    @PutMapping("updateUser")
    public Result updateUserInfo(@RequestBody@Validated User user){
            userService.updateUserInfo(user);
            return Result.success("更新成功");


    }

}
