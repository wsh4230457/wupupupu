package com.home.wupupupu.service;
import com.home.wupupupu.pojo.User;

import java.util.Map;

public interface UserService {

    User findUserByName(String username);
    void register(String username,String password);
    void  updateUser(User user);

    void updateAvatar(String avatarUrl);

    void updatePassword(Map<String, String> params);
}
