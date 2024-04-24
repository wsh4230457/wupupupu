package com.home.wupupupu.service;

import com.home.wupupupu.mapper.UserMapper;
import com.home.wupupupu.pojo.User;
import com.home.wupupupu.util.MD5Util;
import com.home.wupupupu.util.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUserByName(String username) {
        User user=userMapper.findUserByName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        userMapper.registerUser(username,password);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    @Override
    public void updatePassword(Map<String, String> params) {
        Map<String,Object> map= ThreadLocalUtil.get();
        Integer id=(Integer) map.get("id");
        String username=(String)map.get("username");
       User user=userMapper.findUserByName(username);
        if (user.getPassword().equals(params.get("oldPassword"))){
            throw new RuntimeException("旧密码错误");
        }
        if (!params.get("repeatPassword").equals(params.get("newPassword"))){
            throw new RuntimeException("两次输入密码不一致");
        }

        String password=MD5Util.getMd5(params.get("newPassword"));
        userMapper.updatePassword(password,id);
    }
}
