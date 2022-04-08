package com.ludens.webadmin.mapper;

import com.ludens.webadmin.bean.Account;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    public Account getAcct(Long id);
}
