package com.wangsocial.app.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.entity.PrintCQ;

public interface IPrintCQService extends IService<PrintCQ> {
	/**
	 * 新增印染管理
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> insertPrintCQ(PrintCQ print);

	/**
	 * 编辑印染管理
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> updatePrintCQ(PrintCQ print);

	/**
	 * 查询印染管理
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> selectPrintCQ();

	/**
	 * 删除印染管理
	 * 
	 * @param plan
	 * @return
	 */
	Map<String, Object> deletePrintCQ(String print);

}
