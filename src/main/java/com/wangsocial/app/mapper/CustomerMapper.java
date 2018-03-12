package com.wangsocial.app.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Customer;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * User 表数据库控制层接口
 */
public interface CustomerMapper extends BaseMapper<Customer> {


    @Select("select id,name,phone,company,address,create_date as createDate,end_date as endDate from customer")
    List<Customer> getCustomerList();

}