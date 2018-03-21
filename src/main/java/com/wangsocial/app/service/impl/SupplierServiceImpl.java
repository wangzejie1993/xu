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
import com.wangsocial.app.entity.Supplier;
import com.wangsocial.app.mapper.SupplierMapper;
import com.wangsocial.app.service.ISupplierService;

@Service
public class SupplierServiceImpl extends ServiceImpl<SupplierMapper, Supplier>
		implements ISupplierService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());

	@Override
	public Map<String, Object> insertSupplier(Supplier supplier) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(supplier.getName())
				|| StringUtils.isBlank(supplier.getCompany())
				|| StringUtils.isBlank(supplier.getAddress())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的材料信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			supplier.setId(id);
			supplier.setStatus("1");

			int flag = baseMapper.insert(supplier);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "添加成功");
		return map;
	}

	@Override
	public Map<String, Object> getSupplierList(String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Supplier> list = new ArrayList<Supplier>();
		try {
			if (StringUtils.isBlank(content)) {
				list = baseMapper.getSupplierList();
			} else {
				list = baseMapper.getSupplierListByContent(content);
			}

		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询物料失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deleteSupplier(Supplier supplier) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(supplier.getId())) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			supplier.setStatus("0");// 逻辑删除
			int flag = baseMapper.updateById(supplier);
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
