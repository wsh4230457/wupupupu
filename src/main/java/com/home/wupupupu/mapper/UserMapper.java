package com.home.wupupupu.mapper;

import com.home.wupupupu.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
@Select("select * from user where username=#{username}")
    User findUserByName(String username);
@Insert("insert into user(username,password,create_time,update_time)" +
        " values (#{username},#{password},now(),now())")
    void registerUser(String username, String password);
@Update("update user set nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id} ")
    void updateUserInfo(User user);
}
