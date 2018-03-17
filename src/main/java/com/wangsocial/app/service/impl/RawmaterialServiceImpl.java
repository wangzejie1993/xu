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
import com.wangsocial.app.entity.Rawmaterial;
import com.wangsocial.app.mapper.RawmaterialMapper;
import com.wangsocial.app.service.IRawmaterialService;

@Service
public class RawmaterialServiceImpl extends
		ServiceImpl<RawmaterialMapper, Rawmaterial> implements
		IRawmaterialService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());

	@Override
	public Map<String, Object> insertRawmaterial(Rawmaterial rawmaterial) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(rawmaterial.getName())
				|| StringUtils.isBlank(rawmaterial.getNum())
				|| StringUtils.isBlank(rawmaterial.getDutyer())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的材料信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			rawmaterial.setId(id);
			rawmaterial.setSurplus(rawmaterial.getNum());

			int flag = baseMapper.insert(rawmaterial);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "材料添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，材料添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "材料添加成功");
		return map;
	}

	@Override
	public Map<String, Object> getRawmaterialList(String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Rawmaterial> list = new ArrayList<Rawmaterial>();
		try {
			if (StringUtils.isBlank(content)) {
				list = baseMapper.getRawmaterialList();
			} else {
				list = baseMapper.getRawmaterialListByContent(content);
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
	public Map<String, Object> deleteRawmaterial(Rawmaterial rawmaterial) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(rawmaterial.getId())) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			rawmaterial.setStatus("0");// 逻辑删除
			int flag = baseMapper.updateById(rawmaterial);
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
