package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Task;

public interface ITaskService extends IService<Task> {
	/**
	 * 新增任务
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertTask(Task task);

	/**
	 * 编辑任务
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> updateTask(Task task);

	/**
	 * 查询任务
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectTask();

	/**
	 * 删除任务
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> deleteTask(String task);

}
