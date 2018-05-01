package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.PrintCQ;
import com.wangsocial.app.service.IPrintCQService;

@RestController
@RequestMapping("/print")
public class PrintController {

	@Autowired
	private IPrintCQService printCQService;

	@RequestMapping(value = "/insertPrint", method = RequestMethod.POST)
	public Map<String, Object> Print(PrintCQ cq) {
		Map<String, Object> map = printCQService.insertPrintCQ(cq);
		return map;
	}

	@RequestMapping(value = "/deleteTask", method = RequestMethod.POST)
	public Map<String, Object> deleteTaskPlan(String id) {
		Map<String, Object> map = printCQService.deletePrintCQ(id);
		return map;
	}

	@RequestMapping(value = "/updatePrint", method = RequestMethod.POST)
	public Map<String, Object> updateTaskPlan(PrintCQ cq) {
		Map<String, Object> map = printCQService.updatePrintCQ(cq);
		return map;
	}

	@RequestMapping(value = "/getPrintListBySearch", method = RequestMethod.POST)
	public Map<String, Object> getTaskPlanListBySearch(String search) {
		Map<String, Object> map = printCQService.selectPrintCQ();
		return map;
	}
}
