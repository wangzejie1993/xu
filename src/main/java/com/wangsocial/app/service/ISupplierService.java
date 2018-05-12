package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Supplier;

public interface ISupplierService extends IService<Supplier> {

	/**
	 * 新增供应商
	 * 
	 * @param supplier
	 * @return
	 */
	Map<String, Object> insertSupplier(Supplier supplier);

	/**
	 * 获取供应商数据
	 * 
	 * @param content
	 * @return
	 */
	Map<String, Object> getSupplierList(String content);

	/**
	 * 删除 供应商
	 * 
	 * @param supplier
	 * @return
	 */
	Map<String, Object> deleteSupplier(Supplier supplier);
	
	/**
	 * 根据id查询数据
	 * @param id
	 * @return
	 */
	Map<String, Object> selectById(String id);
	
	/**
	 * 更新
	 * @param supplier
	 * @return
	 */
	Map<String, Object> updateSupplier(Supplier supplier);
}
