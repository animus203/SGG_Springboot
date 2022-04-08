package com.ludens.helloworld;

import ch.qos.logback.core.db.DBHelper;
import com.ludens.helloworld.bean.Pet;
import com.ludens.helloworld.bean.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication//(scanBasePackages = "com.ludens")  可以修改包扫描的范围
//等同于
//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan("com.ludens.helloworld")
public class HelloworldApplication {

    public static void main(String[] args) {
        //返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(HelloworldApplication.class, args);

        //打印容器内的所有组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //从容器中获取组件
        Pet tom = run.getBean("Tom", Pet.class);
        System.out.println(tom);

        //获取配置类中import的组件
        DBHelper userBean = run.getBean(DBHelper.class);
        System.out.println(userBean);

    }

}
