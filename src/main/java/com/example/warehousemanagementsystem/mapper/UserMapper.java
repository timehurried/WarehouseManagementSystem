package com.example.warehousemanagementsystem.mapper;

import com.example.warehousemanagementsystem.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 登录方法
    User login(User user);
}
