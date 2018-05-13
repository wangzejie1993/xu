package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.PrintCQ;
import com.wangsocial.app.mapper.PrintCQMapper;
import com.wangsocial.app.service.IPrintCQService;

@Service
public class PrintCQServiceImpl extends ServiceImpl<PrintCQMapper, PrintCQ> implements IPrintCQService {

	@Override
	public Map<String, Object> insertPrintCQ(PrintCQ print) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(print.getName()) || StringUtils.isBlank(print.getOther())
				|| StringUtils.isBlank(print.getPrint_id()) || StringUtils.isBlank(print.getPrint_name())
				|| StringUtils.isBlank(print.getPrint_num()) || StringUtils.isBlank(print.getPrint_time())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的打印信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			print.setId(id);
			int flag = baseMapper.insert(print);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "打印添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，打印添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "生产计划添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updatePrintCQ(PrintCQ print) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			int flag = baseMapper.updateAllColumnById(print);
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
	public Map<String, Object> selectPrintCQ() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<PrintCQ> list = new ArrayList<PrintCQ>();
		try {
			list = baseMapper.selectList(null);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询打印失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deletePrintCQ(String print) {
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

	@Override
	public Map<String, Object> selectById(String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		PrintCQ print = new PrintCQ();
		if (StringUtils.isBlank(id)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			print = baseMapper.selectById(id);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询失败");
			return map;
		}
		map.put("cus", print);
		map.put("ret", 1);
		map.put("msg", "查询成功");
		return map;

	}

}
