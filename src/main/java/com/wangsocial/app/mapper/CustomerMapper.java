package com.wangsocial.app.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Customer;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * User 表数据库控制层接口
 */
public interface CustomerMapper extends BaseMapper<Customer> {


    @Select("select id,name,phone,company,address,create_date as createDate,end_date as endDate from erp_customer order by create_date desc")
    List<Customer> getCustomerList();
    
    @Select("select id,name,phone,company,address,create_date as createDate,end_date as endDate from erp_customer "
    		+ " where name like concat('%',#{search},'%') or phone like concat('%',#{search},'%') or company like concat('%',#{search},'%') "
    		+ "  order by create_date desc")
    List<Customer> getCustomerListBySearch(String search);

}