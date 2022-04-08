package com.ludens.webadmin.config;

import com.ludens.webadmin.interceptor.LoginInterceptor;
import com.ludens.webadmin.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebAdminConfig implements WebMvcConfigurer {

    /**
     * Filter,Interceptor拥有相同功能？
     * Filter为Servlet原生组件，脱离Spring也能使用
     * Interceptor是Spring定义，可以使用自动装配功能
     */
    //@Autowired
    //RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")         //所有请求都会被拦截，包括静态资源
                .excludePathPatterns("/","/login","/css/**","/fonts/**", "/images/**","/js/**");
        //registry.addInterceptor(redisUrlCountInterceptor)
                //.addPathPatterns("/**")
                //.excludePathPatterns("/","/login","/css/**","/fonts/**", "/images/**","/js/**");
    }
}
