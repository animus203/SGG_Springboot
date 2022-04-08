package com.ludens.helloworld.config;

import ch.qos.logback.core.db.DBHelper;
import com.ludens.helloworld.bean.Pet;
import com.ludens.helloworld.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import({DBHelper.class})                     //给容器中导入组件
@Configuration(proxyBeanMethods = true)  //告诉springboot这是一个配置类 == 配置文件
                                        //proxyBeanMethods true：保持容器单实例
public class MyConfig {

    @Bean               //给容器中添加组件，方法名作为组件id，返回类型为组件类型
    //返回的值即为组件在容器中的实例
    //无论外部调用多少次，获取的都是一样的实例
    //但如果proxyBeanMethods为false，就不保证了

    public User user01() {
        User zhangsan = new User("zhangsan", 19);
        zhangsan.setPet(pet01());
        return zhangsan;
    }

    @Bean("Tom")        //可以自定名称
    public Pet pet01() {
        return new Pet("tomcat");
    }

}
