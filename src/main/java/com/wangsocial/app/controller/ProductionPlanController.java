package com.wangsocial.app.controller;

import com.wangsocial.app.entity.Customer;
import com.wangsocial.app.entity.Production_plan;
import com.wangsocial.app.service.ICustomerService;
import com.wangsocial.app.service.IProductionPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/production_plan")
public class ProductionPlanController {

	@Autowired
	private IProductionPlanService productionPlanService;

	@RequestMapping(value="/insertproductionplan",method = RequestMethod.POST)
	public Map<String,Object> insertProductionPlan(Production_plan plan){
		Map<String,Object> map = productionPlanService.insertProductionPlan(plan);
		return map;
	}
	
	@RequestMapping(value="/deleteProductionPlan",method = RequestMethod.POST)
	public Map<String,Object> deleteProductionPlan(String plan){
		Map<String,Object> map = productionPlanService.deleteProductionPlan(plan);
		return map;
	}
	
	@RequestMapping(value="/updateProductionPlan",method = RequestMethod.POST)
	public Map<String,Object> updateProductionPlan(Production_plan plan){
		Map<String,Object> map = productionPlanService.updateProductionPlan(plan);
		return map;
	}
	
	@RequestMapping(value="/getProductionListBySearch",method = RequestMethod.POST)
	public Map<String,Object> getProductionPlanListBySearch(String search){
		Map<String,Object> map = productionPlanService.selectProductionPlan();
		return map;
	}
	
	
	
}
