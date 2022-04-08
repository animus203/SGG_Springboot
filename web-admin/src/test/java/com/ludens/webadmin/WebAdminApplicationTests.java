package com.ludens.webadmin;

import com.ludens.webadmin.bean.User;
import com.ludens.webadmin.mapper.UserMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.List;

@Slf4j
@SpringBootTest
class WebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads(){
        Long s = jdbcTemplate.queryForObject("select count(*) from tbl_employee", Long.class);
        System.out.println(s);
        log.info(String.valueOf(dataSource.getClass()));
    }

    @Autowired
    StringRedisTemplate stringRedisTemplate;


    @Test
    void testRedis(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("hello","world");
        System.out.println(ops.get("hello"));
    }

}
