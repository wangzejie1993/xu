package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Finished_production;

public interface IFinishedStockService extends IService<Finished_production> {

	/**
	 * 新增外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertFinishedStock(Finished_production production);

	/**
	 * 编辑外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> updateFinishedStock(Finished_production production);

	/**
	 * 查询外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectFinishedStock();

	/**
	 * 删除外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> deleteFinishedStock(String production);

}
