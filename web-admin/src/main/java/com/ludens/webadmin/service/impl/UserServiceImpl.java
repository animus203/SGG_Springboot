package com.ludens.webadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ludens.webadmin.bean.User;
import com.ludens.webadmin.mapper.UserMapper;
import com.ludens.webadmin.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
