package com.wangsocial.app.controller;

import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.service.ICustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Map<String,Object> insertCustomer(Customer customer){
		Map<String,Object> map = customerService.insertCustomer(customer);
		return map;
	}
}
