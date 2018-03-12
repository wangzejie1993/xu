package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.mapper.CustomerMapper;
import com.wangsocial.app.service.ICustomerService;
import com.wangsocial.app.util.BasePatterns;

/**
 *
 * Customer 表数据服务层接口实现类
 *
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

	@Autowired
	CustomerMapper customerMapper;
	
	@Override
	public Map<String,Object> insertCustomer(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(customer.getName()) || StringUtils.isBlank(customer.getName()) 
				|| StringUtils.isBlank(customer.getName()) ||StringUtils.isBlank(customer.getName())){
			map.put("ret", -1);
			map.put("msg", "有未填写的信息");
			return map;
		}
		if(!customer.getPhone().matches(BasePatterns.PHONE_FORMAT)){
			map.put("ret", -1);
			map.put("msg", "手机格式错误");
			return map;
		}
		try{
			String id = UUID.randomUUID().toString().replace("-", "");
			customer.setId(id);
			int flag = baseMapper.insert(customer);
			if(flag != 1){
				map.put("ret", -1);
				map.put("msg", "添加客户失败");
				return map;
			}
		}catch(Exception e){
			map.put("ret", -1);
			map.put("msg", "程序出错，添加客户失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "添加成功");
		return map;
	}

	@Override
	public Map<String, Object> getCustomerList() {
		Map<String,Object> map = new HashMap<String, Object>();
		
		try{
			List<Customer> customerList = customerMapper.getCustomerList();
			map.put("cl", customerList);
			map.put("ret", 1);
			map.put("msg", "获取成功");
			return map;
		}catch(Exception e){
			map.put("ret", -1);
			map.put("msg", "获取失败");
			return map;
		}
	}

	@Override
	public Map<String, Object> deleteCustomer(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		String id = customer.getId();
		if(StringUtils.isBlank(id)){
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try{
			int flag = baseMapper.deleteById(id);
			if(flag != 1){
				map.put("ret", -1);
				map.put("msg", "删除失败");
				return map;
			}
		}catch(Exception e){
			map.put("ret", -1);
			map.put("msg", "程序出错，删除失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "删除成功");
		return map;
	}

	
}