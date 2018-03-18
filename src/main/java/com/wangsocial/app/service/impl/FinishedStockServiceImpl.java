package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Finished_production;
import com.wangsocial.app.mapper.FinishedStockMapper;
import com.wangsocial.app.service.IFinishedStockService;
@Service
public class FinishedStockServiceImpl extends ServiceImpl<FinishedStockMapper, Finished_production>
		implements IFinishedStockService {

	@Override
	public Map<String, Object> insertFinishedStock(Finished_production production) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(production.getName())
				|| StringUtils.isBlank(production.getAddNum())
				|| StringUtils.isBlank(production.getOutNum())
				|| StringUtils.isBlank(production.getPersonName())
				|| StringUtils.isBlank(production.getOther())
				) {
			map.put("ret", -1);
			map.put("msg", "有未填写的完成品信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			production.setId(id);
			int flag = baseMapper.insert(production);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "完成品添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，完成品添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "完成品添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updateFinishedStock(Finished_production production) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			
			int flag = baseMapper.updateAllColumnById(production);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "完成品更新失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，完成品更新失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "完成品更新成功");
		return map;
	}

	@Override
	public Map<String, Object> selectFinishedStock() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Finished_production> list = new ArrayList<Finished_production>();
		try {
				list = baseMapper.selectList(null);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询生完成品失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deleteFinishedStock(String production) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(production)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(production);
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
