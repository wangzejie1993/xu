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
	Map<String,Object> insertCustomer(Customer customer,String orderId,String orderName);
	
	/**
	 * 获取客户列表
	 * @return
	 */
	Map<String,Object> getCustomerList();
	
	/**
	 * 删除客户
	 * @param customer
	 * @return
	 */
	Map<String,Object> deleteCustomer(Customer customer);
	
	/**
	 * 根据id获取客户信息
	 * @param customer
	 * @return
	 */
	Map<String,Object> getCustomerById(Customer customer);
	
	/**
	 * 更新客户信息
	 * @param customer
	 * @return
	 */
	Map<String,Object> updateCustomerById(Customer customer);
	
	/**
	 * 根据信息搜索客户
	 * @param search
	 * @return
	 */
	Map<String,Object> getCustomerListBySearch(String search);
	
	/**
	 * 下达订单
	 * @param search
	 * @return
	 */
	Map<String,Object> goDownOrder(String id,String orderName);
}