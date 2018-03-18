package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.Out_company;

public interface IOutCompanyService extends IService<Out_company> {

	/**
	 * 新增外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertOutCompanyn(Out_company company);

	/**
	 * 编辑外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> updateOutCompany(Out_company company);

	/**
	 * 查询外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectOutCompany();

	/**
	 * 删除外协
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> deleteOutCompany(String company);

}
