package com.example.warehousemanagementsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.warehousemanagementsystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping(value = "/login", produces = "application/json;charseet=UTF-8")
    public JSONObject login(@RequestBody JSONObject object) {
//        loginService.login(object);
        System.out.println("====");
        System.out.println(object.toJSONString());
        return loginService.login(object);
    }
}
