package com.wangsocial.app.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.entity.User;

/**
 *
 * User 表数据服务层接口
 *
 */
public interface ICustomerService extends IService<Customer> {

	/**
	 * 新增客户
	 * @return
	 */
	Map<String,Object> insertCustomer(Customer customer);
	
	/**
	 * 获取客户列表
	 * @return
	 */
	Map<String,Object> getCustomerList();
	
	Map<String,Object> deleteCustomer(Customer customer);
}