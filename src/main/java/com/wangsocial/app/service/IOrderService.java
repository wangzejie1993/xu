package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Order;

public interface IOrderService extends IService<Order> {
	/*
	 * 增加订单
	 */
	Map<String, Object> addOrder(Order order);
	
	/*
	 * 修改订单
	 */
	Map<String, Object> updateOrder(Order order);
	
	/*
	 * 全量查询订单
	 */
	Map<String, Object> selectAllOrder();
	
	/*
	 * 根据id查询订单
	 */
	Map<String, Object> selectByIdOrder(String id);
	
	/*
	 * 删除订单
	 */
	Map<String, Object> deletByIdOrder(String id);

}
