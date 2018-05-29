package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.entity.CustomerOrderReleation;
import com.wangsocial.app.entity.Order;
import com.wangsocial.app.entity.OrderProductionReleation;
import com.wangsocial.app.mapper.CustomerMapper;
import com.wangsocial.app.mapper.CustomerOrderReleationMapper;
import com.wangsocial.app.mapper.OrderMapper;
import com.wangsocial.app.service.ICustomerService;
import com.wangsocial.app.util.BasePatterns;

/**
 *
 * Customer 表数据服务层接口实现类
 *
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private CustomerOrderReleationMapper coReleationMapper;
	
	@Override
	public Map<String,Object> insertCustomer(Customer customer,String orderId,String orderName) {
		if (StringUtils.isBlank(orderId) || StringUtils.isBlank(orderName)) {
			Map<String,Object> map = new HashMap<String, Object>();
			if(StringUtils.isBlank(customer.getName()) || StringUtils.isBlank(customer.getPhone()) 
					|| StringUtils.isBlank(customer.getCompany()) ||StringUtils.isBlank(customer.getAddress())){
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
		}else {
			Map<String,Object> map = new HashMap<String, Object>();
			if(StringUtils.isBlank(customer.getName()) || StringUtils.isBlank(customer.getPhone()) 
					|| StringUtils.isBlank(customer.getCompany()) ||StringUtils.isBlank(customer.getAddress())){
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
				
				// opMapper 添加订单与 工艺关联关系
				OrderProductionReleation opr = new OrderProductionReleation();
				opr.setId(UUID.randomUUID().toString().replace("-", ""));
				opr.setOrderId(dto.getOrderId());
				opr.setOrderName(dto.getOrderName());
				opr.setProductionId(productionId);
				opr.setProductionName(dto.getName());
				int opFlag = opMapper.insert(opr);
				if (opFlag != 1) {
					map.put("ret", -1);
					map.put("msg", "添加 订单与工艺关联关系失败");
					return map;
				}

				// 更新订单状态
				Order order = new Order();
				order.setId(dto.getOrderId());
				order.setOrderProcess("2");
				int oFlag = orderMapper.updateById(order);
				if (oFlag != 1) {
					map.put("ret", -1);
					map.put("msg", "更新订单状态失败");
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

	@Override
	public Map<String, Object> getCustomerList() {
		Map<String,Object> map = new HashMap<String, Object>();
		
		try{
			List<Customer> customerList = baseMapper.getCustomerList();
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

	@Override
	public Map<String, Object> getCustomerById(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		String id = customer.getId();
		if(StringUtils.isBlank(id)){
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		Customer cus = null;
		try{
			cus = baseMapper.selectById(customer.getId());
			if(null == cus){
				map.put("ret", -1);
				map.put("msg", "获取失败");
				return map;
			}
		}catch(Exception e){
			map.put("ret", -1);
			map.put("msg", "程序出错，获取失败");
			return map;
		}
		map.put("cus", cus);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> updateCustomerById(Customer customer) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(customer.getId())){
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		if(StringUtils.isBlank(customer.getName()) || StringUtils.isBlank(customer.getPhone()) 
				|| StringUtils.isBlank(customer.getCompany()) || StringUtils.isBlank(customer.getAddress())){
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
			baseMapper.updateById(customer);
		}catch(Exception e){
			map.put("ret", -1);
			map.put("msg", "程序出错，更新失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "更新成功");
		return map;
	}

	@Override
	public Map<String, Object> getCustomerListBySearch(String search) {
		Map<String,Object> map = new HashMap<String, Object>();
		try{
			List<Customer> customerList = baseMapper.getCustomerListBySearch(search);
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

	@Transactional
	@Override
	public Map<String, Object> goDownOrder(String id, String orderName) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(StringUtils.isBlank(id) || StringUtils.isBlank(orderName)){
			map.put("ret", -1);
			map.put("msg", "信息不能为空");
			return map;
		}
		Order order = new Order();
		order.setId(UUID.randomUUID().toString().replace("-", ""));
		order.setName(orderName);
		try{
			int flag = orderMapper.insert(order);
			if(flag != 1){
				map.put("ret", -1);
				map.put("msg", "订单新增失败");
				return map;
			}
			Customer cus = baseMapper.selectById(id);
			if(null == cus){
				map.put("ret", -1);
				map.put("msg", "查询客户失败");
				return map;
			}
			CustomerOrderReleation rel = new CustomerOrderReleation();
			rel.setId(UUID.randomUUID().toString().replace("-", ""));
			rel.setCustomerId(cus.getId());
			rel.setCustomerName(cus.getName());
			rel.setOrderId(order.getId());
			rel.setOrderName(orderName);
			rel.setStatus("1");
			
			int flag1 = coReleationMapper.insert(rel);
			if(flag1 != 1){
				map.put("ret", -1);
				map.put("msg", "新增客户订单关系失败");
				return map;
			}
		}catch(Exception e){
			LOGGER.error(e);
			map.put("ret", -1);
			map.put("msg", "程序出错");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "订单下达成功");
		return map;
	}
	
}