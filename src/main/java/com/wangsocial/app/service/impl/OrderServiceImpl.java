package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Order;
import com.wangsocial.app.mapper.OrderMapper;
import com.wangsocial.app.service.IOrderService;

public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {

	@Override
	public Map<String, Object> addOrder(Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(order.getName()) || StringUtils.isBlank(order.getProbleOrder())
				|| StringUtils.isBlank(order.getStatus())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			order.setId(id);
			int flag = baseMapper.insert(order);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "添加订单失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，添加订单失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updateOrder(Order order) {
	Map<String, Object> map = new HashMap<String, Object>();
	if (StringUtils.isBlank(order.getName()) || StringUtils.isBlank(order.getProbleOrder())
			|| StringUtils.isBlank(order.getStatus())) {
		map.put("ret", -1);
		map.put("msg", "有未填写的信息");
		return map;
	}
	try {
		String id = UUID.randomUUID().toString().replace("-", "");
		order.setId(id);
		int flag = baseMapper.update(order, null);
		if (flag != 1) {
			map.put("ret", -1);
			map.put("msg", "更新订单失败");
			return map;
		}
	} catch (Exception e) {
		map.put("ret", -1);
		map.put("msg", "程序出错，更新订单失败");
		return map;
	}
	map.put("ret", 1);
	map.put("msg", "更新成功");
	return map;
	}

	@Override
	public Map<String, Object> selectAllOrder() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Order> list = new ArrayList<>();
		try {
			list = baseMapper.selectAll();
			if (list.size() != 1) {
				map.put("ret", -1);
				map.put("msg", "查询订单失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询订单失败");
			return map;
		}
		map.put("ret", list);
		map.put("msg", "更新成功");
		return map;
		}

	@Override
	public Map<String, Object> selectByIdOrder(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Order order = new Order();
		try {
			order = baseMapper.selectById(id);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询订单失败");
			return map;
		}
		map.put("ret", order);
		map.put("msg", "更新成功");
		return map;
		}

	@Override
	public Map<String, Object> deletByIdOrder(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(id) ) {
			map.put("ret", -1);
			map.put("msg", "有未填写的信息");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(id);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "删除订单失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，删除订单失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "删除订单成功");
		return map;
	}

}
