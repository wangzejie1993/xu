package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Order;
import com.wangsocial.app.mapper.OrderMapper;
import com.wangsocial.app.service.IOrderService;
import com.wangsocial.app.util.OrderStatusConstants;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements
		IOrderService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());

	@Override
	public Map<String, Object> addOrder(Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(order.getName())) {
			map.put("ret", -1);
			map.put("msg", "订单名称不能为空");
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
		map.put("msg", "订单添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updateOrder(Order order) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(order.getName())
				|| StringUtils.isBlank(order.getProbleOrder())
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
	public Map<String, Object> selectOrder(String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Order> list = new ArrayList<>();
		try {
			if (StringUtils.isBlank(content)) {
				list = baseMapper.selectOrder();
			} else {
				list = baseMapper.selectOrderByContent(content);
			}

		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询订单失败");
			return map;
		}
		for (Order o : list) {
			if ("1".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.RELEASE_ORDER);
			} else if ("2".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.PRODUCTION_TECHNICS);
			} else if ("3".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.PRODUCTION_PLAN);
			} else if ("4".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.PRODUCTION_TASK);
			} else if ("5".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.PROVIDE_MATERIAL);
			} else if ("6".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.MACHINING);
			} else if ("7".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.DIPDYE);
			} else if ("8".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.FINISHED_PRODUCT);
			} else if ("9".equals(o.getOrderProcess())) {
				o.setOrderProcess(OrderStatusConstants.FINISHED_ORDER);
			}
		}
		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
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
			map.put("msg", "程序出错，获取失败");
			return map;
		}
		map.put("ret", -1);
		map.put("order", order);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deletByIdOrder(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(id)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}

		try {
			Order order = new Order();
			order.setId(id);
			order.setStatus("0");
			int flag = baseMapper.updateById(order);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "删除订单失败");
				return map;
			}
		} catch (Exception e) {
			LOGGER.error(e);
			map.put("ret", -1);
			map.put("msg", "程序出错，删除订单失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "删除订单成功");
		return map;
	}

}
