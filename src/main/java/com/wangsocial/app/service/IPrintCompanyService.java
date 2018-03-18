package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.PrintCompany;

public interface IPrintCompanyService extends IService<PrintCompany> {
	/**
	 * 新增印染
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertPrintCompany(PrintCompany print);

	/**
	 * 编辑印染
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> updatePrintCompany(PrintCompany print);

	/**
	 * 查询印染
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectPrintCompany();

	/**
	 * 删除印染
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> deletePrintCompany(String print);

}
