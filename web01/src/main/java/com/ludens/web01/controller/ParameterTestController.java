package com.ludens.web01.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParameterTestController {
    //car/1
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> getCar(@PathVariable("id") Integer id,
                                     @PathVariable("username") String username,
                                     //@PathVariable Map<String, String> pv,              //地址栏传入参数
                                     @RequestHeader("User-Agent") String userAgent     //请求头
                                     //@RequestParam("age") Integer age                  //地址栏传入参数：格式不同
                                    // @CookieValue("_ga") String _ga                            //查询cookie
                                     ){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username",username);
        //map.put("pv", pv);
        map.put("userAgent", userAgent);
        //map.put("age", age);
        //map.put("_ga", _ga);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }
}
