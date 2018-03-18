package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.PrintCompany;
import com.wangsocial.app.mapper.PrintCompanyMapper;
import com.wangsocial.app.service.IPrintCompanyService;

public class PrintCompanyServiceImpl extends ServiceImpl<PrintCompanyMapper, PrintCompany>
		implements IPrintCompanyService {

	@Override
	public Map<String, Object> insertPrintCompany(PrintCompany print) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(print.getName())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的印染企业信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			print.setId(id);
			int flag = baseMapper.insert(print);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "印染企业添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，印染企业添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "印染企业添加成功");
		return map;

	}

	@Override
	public Map<String, Object> updatePrintCompany(PrintCompany print) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			int flag = baseMapper.updateAllColumnById(print);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "印染企业更新失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，印染企业更新失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "印染企业更新成功");
		return map;
	}

	@Override
	public Map<String, Object> selectPrintCompany() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrintCompany> list = new ArrayList<PrintCompany>();
		try {
			list = baseMapper.selectList(null);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询印染企业失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deletePrintCompany(String print) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(print)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(print);
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
