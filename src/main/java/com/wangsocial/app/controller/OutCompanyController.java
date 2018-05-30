package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Out_company;
import com.wangsocial.app.service.IOutCompanyService;

@RestController
@RequestMapping("/outcompany")
public class OutCompanyController {

	@Autowired
	private IOutCompanyService outCompanyService;

	@RequestMapping(value = "/insertoutcompany", method = RequestMethod.POST)
	public Map<String, Object> insertProductionPlan(Out_company plan,
			@RequestParam(value="orderId")String orderId,
			@RequestParam(value="orderName")String orderName) {
		Map<String, Object> map = outCompanyService.insertOutCompanyn(plan,orderId,orderName);
		return map;
	}

	@RequestMapping(value = "/deleteoutcompany", method = RequestMethod.POST)
	public Map<String, Object> deleteProductionPlan(String id) {
		Map<String, Object> map = outCompanyService.deleteOutCompany(id);
		return map;
	}

	@RequestMapping(value = "/updateoutcompany", method = RequestMethod.POST)
	public Map<String, Object> updateProductionPlan(Out_company plan) {
		Map<String, Object> map = outCompanyService.updateOutCompany(plan);
		return map;
	}

	@RequestMapping(value = "/getoutcompanyListBySearch", method = RequestMethod.POST)
	public Map<String, Object> getProductionPlanListBySearch() {
		Map<String, Object> map = outCompanyService.selectOutCompany();
		return map;
	}
	
	@RequestMapping(value = "/getoutcompanyListById", method = RequestMethod.POST)
	public Map<String, Object> getProductionPlanListById(String id) {
		Map<String, Object> map = outCompanyService.selectById(id);
		return map;
	}
}
