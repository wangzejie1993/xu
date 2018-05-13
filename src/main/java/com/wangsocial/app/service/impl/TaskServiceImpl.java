package com.wangsocial.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Task;
import com.wangsocial.app.mapper.TaskMapper;
import com.wangsocial.app.service.ITaskService;

@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements ITaskService {

	@Override
	public Map<String, Object> insertTask(Task task) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(task.getName()) || StringUtils.isBlank(task.getContext())
				|| StringUtils.isBlank(task.getFinished())
				|| StringUtils.isBlank(task.getOutcompany_hep())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的任务信息");
			return map;
		}
		try {
			String id = UUID.randomUUID().toString().replace("-", "");
			task.setId(id);
			task.setCreateDate(new Date());
			task.setEndDate(new Date());
			task.setCommiect("1");
			int flag = baseMapper.insert(task);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "任务添加失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，任务添加失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "认为添加成功");
		return map;
	}

	@Override
	public Map<String, Object> updateTask(Task task) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {

			int flag = baseMapper.updateAllColumnById(task);
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
	public Map<String, Object> selectTask() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Task> list = new ArrayList<Task>();
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
	public Map<String, Object> deleteTask(String task) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(task)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			int flag = baseMapper.deleteById(task);
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
		Task task = new Task();
		if (StringUtils.isBlank(id)) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			task =baseMapper.selectById(id);
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询失败");
			return map;
		}
		map.put("cus", task);
		map.put("ret", 1);
		map.put("msg", "查询成功");
		return map;
	}

}
