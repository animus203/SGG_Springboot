package com.ludens.webadmin.mapper;

import com.ludens.webadmin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface CityMapper {
    @Select("select * from city where id=#{id}")
    public City getCityById(Long id);
}
