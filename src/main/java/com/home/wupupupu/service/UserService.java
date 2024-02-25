package com.home.wupupupu.service;
import com.home.wupupupu.pojo.User;

public interface UserService {

    User findUserByName(String username);
    void register(String username,String password);
    void updateUserInfo(User user);
}
