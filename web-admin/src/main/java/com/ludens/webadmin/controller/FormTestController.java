package com.ludens.webadmin.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


/**
 * 文件上传测试
 */
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos){

    if (!headerImg.isEmpty()){
        //保存文件
        String filename = headerImg.getOriginalFilename();
        try {
            headerImg.transferTo(new File("D:\\"+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    if(photos.length > 0){
        for (MultipartFile photo : photos) {
            if (!photo.isEmpty()) {
                String originName = photo.getOriginalFilename();
                try {
                    photo.transferTo(new File("D:\\Cache\\"+ originName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
        return "main";
    }
}
