package com.wangsocial.app.controller;

import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value="/insertCustomer",method = RequestMethod.POST)
	public Map<String,Object> insertCustomer(Customer customer,
			@RequestParam(value="orderId")String orderId,
			@RequestParam(value="orderName")String orderName){
		Map<String,Object> map = customerService.insertCustomer(customer);
		return map;
	}
	
	@RequestMapping(value="/getCustomerList",method = RequestMethod.POST)
	public Map<String,Object> getCustomerList(){
		Map<String,Object> map = customerService.getCustomerList();
		return map;
	}
	
	@RequestMapping(value="/deleteCustomer",method = RequestMethod.POST)
	public Map<String,Object> deleteCustomer(Customer customer){
		Map<String,Object> map = customerService.deleteCustomer(customer);
		return map;
	}
	
	@RequestMapping(value="/getCustomerById",method = RequestMethod.POST)
	public Map<String,Object> getCustomerById(Customer customer){
		Map<String,Object> map = customerService.getCustomerById(customer);
		return map;
	}
	
	@RequestMapping(value="/updateCustomerById",method = RequestMethod.POST)
	public Map<String,Object> updateCustomerById(Customer customer){
		Map<String,Object> map = customerService.updateCustomerById(customer);
		return map;
	}
	
	@RequestMapping(value="/getCustomerListBySearch",method = RequestMethod.POST)
	public Map<String,Object> getCustomerListBySearch(String search){
		Map<String,Object> map = customerService.getCustomerListBySearch(search);
		return map;
	}
	
	@RequestMapping(value="/goDownOrder",method = RequestMethod.POST)
	public Map<String,Object> goDownOrder(String id,String orderName){
		Map<String,Object> map = customerService.goDownOrder(id, orderName);
		return map;
	}
	
}
