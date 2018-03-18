package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Task;
import com.wangsocial.app.service.ITaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private ITaskService taskService;

	@RequestMapping(value = "/insertTask", method = RequestMethod.POST)
	public Map<String, Object> insertTaskPlan(Task plan) {
		Map<String, Object> map = taskService.insertTask(plan);
		return map;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	public Map<String, Object> deleteTaskPlan(String plan) {
		Map<String, Object> map = taskService.deleteTask(plan);
		return map;
	}

	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public Map<String, Object> updateTaskPlan(Task plan) {
		Map<String, Object> map = taskService.updateTask(plan);
		return map;
	}

	@RequestMapping(value = "/getTaskListBySearch", method = RequestMethod.POST)
	public Map<String, Object> getTaskPlanListBySearch(String search) {
		Map<String, Object> map = taskService.selectTask();
		return map;
	}
}
