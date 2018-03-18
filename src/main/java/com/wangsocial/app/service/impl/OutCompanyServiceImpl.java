package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Out_company;
import com.wangsocial.app.entity.Production_plan;
import com.wangsocial.app.mapper.OutCompanyMapper;
import com.wangsocial.app.service.IOutCompanyService;

@Service
public class OutCompanyServiceImpl extends ServiceImpl<OutCompanyMapper, Out_company> implements IOutCompanyService {

	@Override
	public Map<String, Object> insertOutCompanyn(Out_company company) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(company.getName())
				|| StringUtils.isBlank(company.getTaskId())
				|| StringUtils.isBlank(company.getTaskName())
				|| StringUtils.isBlank(company.getPlanRawmaterial())
				|| StringUtils.isBlank(company.getNowRawmterialNum())
				|| StringUtils.isBlank(company.getAppendContext())
				|| StringUtils.isBlank(company.getAppend())
				|| StringUtils.isBlank(company.getAppendNum())
				|| StringUtils.isBlank(company.getAppendContext())
				|| StringUtils.isBlank(company.getSurplus())
				|| StringUtils.isBlank(company.getSurplusNum())
				|| StringUtils.isBlank(company.getReturnBl())
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

}
