package com.example.warehousemanagementsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.example.warehousemanagementsystem.bean.User;

public interface LoginService {

     JSONObject login(JSONObject loginJson);
}
