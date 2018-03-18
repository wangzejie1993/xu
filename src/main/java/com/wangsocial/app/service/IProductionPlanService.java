package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Production_plan;

public interface IProductionPlanService extends IService<Production_plan> {
	
	/**
	 * 新增生产计划
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertProductionPlan(Production_plan plan);
	
	/**
	 * 编辑生产计划
	 * @param plan
	 * @return
	 */
	Map<String, Object> updateProductionPlan(Production_plan plan);
	
	
	/**
	 * 查询生产计划
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectProductionPlan();
	
	/**
	 * 删除生产计划
	 * @param plan
	 * @return
	 */
	Map<String, Object> deleteProductionPlan(String plan);

}
