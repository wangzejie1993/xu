package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Order;
import com.wangsocial.app.service.IOrderService;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/
 * MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private IOrderService orderService;

	@RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
	public Map<String, Object> getOrderList(String content) {
		Map<String, Object> map = orderService.selectOrder(content);
		return map;
	}

	@RequestMapping(value = "/deleteOrder", method = RequestMethod.POST)
	public Map<String, Object> deleteOrder(String id) {
		Map<String, Object> map = orderService.deletByIdOrder(id);
		return map;
	}

	@RequestMapping(value = "/insertOrder", method = RequestMethod.POST)
	public Map<String, Object> insertOrder(Order order) {
		Map<String, Object> map = orderService.addOrder(order);
		return map;
	}

}
