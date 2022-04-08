package com.ludens.webadmin.controller;

import com.ludens.webadmin.bean.Account;
import com.ludens.webadmin.bean.User;
import com.ludens.webadmin.mapper.AccountMapper;
import com.ludens.webadmin.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;


@Controller
public class IndexController {
    /**
     * 来登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})//接收到 / /login后 跳转到login.html
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        //登录成功，重定向至main页面，避免表单重复提交

        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";   //重定向，避免刷新后表单重复提交
        }else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }

    }

    /**
     * 去main页面
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model){
        //是否登录。最好使用拦截器或登录器机制
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null){
            return "main";
        }else {
            model.addAttribute("msg", "未登录！");
            return "login";
        }

    }

    @Autowired
    AccountService accountService;


    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Long id){
        return accountService.getAcctById(id);
    }
}
