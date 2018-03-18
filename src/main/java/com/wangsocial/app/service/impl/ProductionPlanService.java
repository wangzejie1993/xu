package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Production_plan;
import com.wangsocial.app.entity.Rawmaterial;
import com.wangsocial.app.mapper.ProductionPlanMapper;
import com.wangsocial.app.service.IProductionPlanService;
@Service
public class ProductionPlanService extends ServiceImpl<ProductionPlanMapper, Production_plan>
		implements IProductionPlanService {

	@Override
	public Map<String, Object> insertProductionPlan(Production_plan plan) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(plan.getName())
				|| StringUtils.isBlank(plan.getProductionId())
				|| StringUtils.isBlank(plan.getProductionName())
				|| StringUtils.isBlank(plan.getRawmaterialId())
				|| StringUtils.isBlank(plan.getRawmaterialName())
				|| StringUtils.isBlank(plan.getPlanTime())
				|| StringUtils.isBlank(plan.getJudge())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的计划信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			plan.setId(id);
			int flag = baseMapper.insert(plan);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "生产计划添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，生产计划添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "生产计划添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updateProductionPlan(Production_plan plan) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			int flag = baseMapper.updateAllColumnById(plan);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "生产计划更新失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，生产计划更新失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "生产计划更新成功");
		return map;
	}

	@Override
	public Map<String, Object> selectProductionPlan() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Production_plan> list = new ArrayList<Production_plan>();
		try {
				list = baseMapper.selectList(null);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询生产计划失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deleteProductionPlan(String plan) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(plan)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(plan);
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

}
