package com.wangsocial.app.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.entity.User;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface CustomerMapper extends BaseMapper<Customer> {


    @Select("insert into ")
    int insertCustomer(Customer customer);

}