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
}
