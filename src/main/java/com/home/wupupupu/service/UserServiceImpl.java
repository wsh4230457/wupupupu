package com.home.wupupupu.service;

import com.home.wupupupu.mapper.UserMapper;
import com.home.wupupupu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
