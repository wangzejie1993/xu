package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Finished_production;
import com.wangsocial.app.service.IFinishedStockService;

@RestController
@RequestMapping("/finishedproduction")
public class FinishedProductionController {

	@Autowired
	private IFinishedStockService finishedStockService;

	@RequestMapping(value = "/insertfinishedproduction", method = RequestMethod.POST)
	public Map<String, Object> insertProductionPlan(Finished_production plan) {
		Map<String, Object> map = finishedStockService.insertFinishedStock(plan);
		return map;
	}

	@RequestMapping(value = "/deleteofinishedproduction", method = RequestMethod.DELETE)
	public Map<String, Object> deleteProductionPlan(String plan) {
		Map<String, Object> map = finishedStockService.deleteFinishedStock(plan);
		return map;
	}

	@RequestMapping(value = "/updatefinishedproduction", method = RequestMethod.PUT)
	public Map<String, Object> updateProductionPlan(Finished_production plan) {
		Map<String, Object> map = finishedStockService.updateFinishedStock(plan);
		return map;
	}

	@RequestMapping(value = "/getfinishedproductionListBySearch", method = RequestMethod.POST)
	public Map<String, Object> getProductionPlanListBySearch() {
		Map<String, Object> map = finishedStockService.selectFinishedStock();
		return map;
	}
}
