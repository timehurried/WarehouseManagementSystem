package com.example.warehousemanagementsystem.service.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.example.warehousemanagementsystem.bean.User;
import com.example.warehousemanagementsystem.mapper.UserMapper;
import com.example.warehousemanagementsystem.service.LoginService;
import com.example.warehousemanagementsystem.util.JWTUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private UserMapper userMapper;// 注入UserMapper


    @Override
    public JSONObject login(JSONObject loginJson) {
        JSONObject jsonObject=new JSONObject();
       try{
           User user=new User();
           user.setUsername(loginJson.getString("username"));
           user.setPassword( loginJson.getString("password"));
           Map<String, String> payload = new HashMap<>();

           payload.put("name", user.getUsername());
           payload.put("password", user.getPassword());

           User loginUser=userMapper.login(user);//根据账号密码查询用户
           System.out.println(loginUser.getId());
           if (loginUser !=null){
               // 生成Token
               String token= JWTUtil.getToken(payload);
               jsonObject.put("status",true);
               jsonObject.put("msg","登陆成功");
               jsonObject.put("token",token);
               return jsonObject;
           }
       }catch (Exception e){
           jsonObject.put("status",false);
           jsonObject.put("msg","登陆失败");
           throw new RuntimeException(e);


       }

        return jsonObject;
    }
}
