package com.zhoujjtech.dao;

import com.zhoujjtech.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface IndexDaoMapper {

    @Select("select * from user")
//    @SelectProvider()
    List<User> select();
}
