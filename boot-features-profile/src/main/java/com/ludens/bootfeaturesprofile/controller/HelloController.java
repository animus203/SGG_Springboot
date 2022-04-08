package com.ludens.bootfeaturesprofile.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${person.name:lisi}")
    private String name;
    @GetMapping("/hello")
    public String Hello(){
        return "Hello "+ name;
    }
}
