package com.example.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    //注册用户
    int addUser(User user);

    //验证用户名
    User findUserName(String userName);

    //验证密码
    String findPassword(String username);

    //删除用户
    int deleteUser(String username);
}
