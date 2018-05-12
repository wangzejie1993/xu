package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Rawmaterial;

public interface IRawmaterialService extends IService<Rawmaterial> {

	/**
	 * 新增物料上
	 * 
	 * @param rawmaterial
	 * @return
	 */
	Map<String, Object> insertRawmaterial(Rawmaterial rawmaterial);

	/**
	 * 获取物料
	 * 
	 * @param content
	 * @return
	 */
	Map<String, Object> getRawmaterialList(String content);

	/**
	 * 删除 物料
	 * 
	 * @param id
	 * @return
	 */
	Map<String, Object> deleteRawmaterial(Rawmaterial rawmaterial);
	
	/**
	 * 根据id查询物料
	 * @param id
	 * @return
	 */
	Map<String, Object> selectRawmaterialById(String id);
	
	/**
	 * 更新物料信息
	 * @param raw
	 * @return
	 */
	Map<String, Object> updateRawmaterial(Rawmaterial raw);
}
