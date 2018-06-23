package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Order;
import com.wangsocial.app.entity.Out_company;
import com.wangsocial.app.entity.Production_plan;
import com.wangsocial.app.mapper.OrderMapper;
import com.wangsocial.app.mapper.OutCompanyMapper;
import com.wangsocial.app.service.IOutCompanyService;

@Service
public class OutCompanyServiceImpl extends ServiceImpl<OutCompanyMapper, Out_company> implements IOutCompanyService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public Map<String, Object> insertOutCompanyn(Out_company company,String orderId,String orderName) {
		if (StringUtils.isBlank(orderId)
				|| StringUtils.isBlank(orderName)) {
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isBlank(company.getName())
					|| StringUtils.isBlank(company.getTaskId())
					|| StringUtils.isBlank(company.getTaskName())
					|| StringUtils.isBlank(company.getOther())
					) {
				map.put("ret", -1);
				map.put("msg", "有未填写的外协企业信息");
				return map;
			}
			try {
				String id = UUID.randomUUID().toString().replace("-", "");
				company.setId(id);
				int flag = baseMapper.insert(company);
				if (flag != 1) {
					map.put("ret", -1);
					map.put("msg", "外协企业添加失败");
					return map;
				}
			} catch (Exception e) {
				map.put("ret", -1);
				map.put("msg", "程序出错，外协企业添加失败");
				return map;
			}
			map.put("ret", 1);
			map.put("msg", "外协企业添加成功");
			return map;
			
		}else{
			Map<String, Object> map = new HashMap<String, Object>();
			if (StringUtils.isBlank(company.getName())
					|| StringUtils.isBlank(company.getTaskId())
					|| StringUtils.isBlank(company.getTaskName())
					|| StringUtils.isBlank(company.getOther())
					) {
				map.put("ret", -1);
				map.put("msg", "有未填写的外协企业信息");
				return map;
			}
			try {
				String id = UUID.randomUUID().toString().replace("-", "");
				company.setId(id);
				int flag = baseMapper.insert(company);
				if (flag != 1) {
					map.put("ret", -1);
					map.put("msg", "外协企业添加失败");
					return map;
				}
				
				// 更新订单状态
				Order order = new Order();
				order.setId(orderId);
				order.setOrderProcess("10");
				int oFlag = orderMapper.updateById(order);
				if (oFlag != 1) {
					map.put("ret", -1);
					map.put("msg", "更新订单状态失败");
					return map;
				}
			} catch (Exception e) {
				map.put("ret", -1);
				map.put("msg", "程序出错，外协企业添加失败");
				return map;
			}
			map.put("ret", 1);
			map.put("msg", "外协企业添加成功");
			return map;
		}
		
	}

	@Override
	public Map<String, Object> updateOutCompany(Out_company company) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			int flag = baseMapper.updateAllColumnById(company);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "外协企业更新失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，外协企业更新失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "外协企业更新成功");
		return map;
	}

	@Override
	public Map<String, Object> selectOutCompany() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Out_company> list = new ArrayList<Out_company>();
		try {
				list = baseMapper.selectList(null);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询生外协企业失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deleteOutCompany(String company) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(company)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(company);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "删除失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，删除失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "删除成功");
		return map;
	}

	@Override
	public Map<String, Object> selectById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		Out_company company = new Out_company();
		if (StringUtils.isBlank(id)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			company = baseMapper.selectById(id);
			
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询失败");
			return map;
		}
		map.put("cus", company);
		map.put("ret", 1);
		map.put("msg", "查询成功");
		return map;
	}

}
