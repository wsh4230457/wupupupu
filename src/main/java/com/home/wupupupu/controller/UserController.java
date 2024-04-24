package com.home.wupupupu.controller;

import com.home.wupupupu.pojo.Result;
import com.home.wupupupu.pojo.User;
import com.home.wupupupu.service.UserService;
import com.home.wupupupu.util.JwtUtil;
import com.home.wupupupu.util.MD5Util;
import com.home.wupupupu.util.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,20}$") String username , @Pattern(regexp = "^\\S{6,32}$") String password){
        if (userService.findUserByName(username)==null){
            password= MD5Util.getMd5(password);
            userService.register(username,password);
            return Result.success();
        }
        return Result.error("注册失败,已有用户名");
    }
    @GetMapping("/login")
    public Result login(@Pattern(regexp = "^\\S{5,20}$") String username , @Pattern(regexp = "^\\S{6,32}$") String password){
        User user=userService.findUserByName(username);
        password= MD5Util.getMd5(password);
        if (user==null){
            return Result.error("用户名不存在");
        }
        if (!password.equals(user.getPassword())){
            return Result.error("密码错误");
        }
        Map<String,Object> claim=new HashMap<>();
        claim.put("username",username);
        claim.put("id",user.getId());
        String token= JwtUtil.getToken(claim);
        return Result.success(token);
    }
    @PutMapping("/update")
    public Result updateUser(@Validated @RequestBody User user){
        user.setUpdateTime(LocalDateTime.now());
        userService.updateUser(user);
        return Result.success("更新用户"+user.getUsername()+"成功");
    }
    @PutMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String AvatarUrl){

        userService.updateAvatar(AvatarUrl);
        return Result.success();
    }
    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String,String> params){
        userService.updatePassword(params);
        return Result.success();
    }
}
