package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Production;
import com.wangsocial.app.entity.ProductionProcessReleationship;

public interface IProductionProcessService extends
		IService<ProductionProcessReleationship> {

	/**
	 * 新增工艺
	 * 
	 * @param dto
	 * @return
	 */
	Map<String, Object> insertProduction(ProductionProcessReleationship dto);

	/**
	 * 获取工艺
	 * 
	 * @param content
	 * @return
	 */
	Map<String, Object> getProductionList(String content);

	/**
	 * 删除 工艺
	 * 
	 * @param dto
	 * @return
	 */
	Map<String, Object> deleteProduction(ProductionProcessReleationship dto);
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	Map<String, Object> selectProduction(String id);
	
	/**
	 * 更新
	 * @param production
	 * @return
	 */
	Map<String,Object> updateProduction(Production production);
}
