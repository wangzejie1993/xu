package com.wangsocial.app.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
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

	
}