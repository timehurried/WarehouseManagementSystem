package com.example.warehousemanagementsystem.config;

import com.example.warehousemanagementsystem.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptor())
                //拦截的路径 ，需要进行token验证的路径
                .addPathPatterns("")
                //不拦截的路径
                .excludePathPatterns("/login");
    }
}
