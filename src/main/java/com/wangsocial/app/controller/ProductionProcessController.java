package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.ProductionProcessReleationship;
import com.wangsocial.app.service.IProductionProcessService;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/
 * MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/productions")
public class ProductionProcessController {

	@Autowired
	private IProductionProcessService ppService;

	@RequestMapping(value = "/insertProduction", method = RequestMethod.POST)
	public Map<String, Object> insertProduction(
			ProductionProcessReleationship dto) {
		Map<String, Object> map = ppService.insertProduction(dto);
		return map;
	}

	@RequestMapping(value = "/getProductionList", method = RequestMethod.POST)
	public Map<String, Object> getProductionList(String content) {
		Map<String, Object> map = ppService.getProductionList(content);
		return map;
	}

	@RequestMapping(value = "/deleteProduction", method = RequestMethod.POST)
	public Map<String, Object> deleteProduction(
			ProductionProcessReleationship dto) {
		Map<String, Object> map = ppService.deleteProduction(dto);
		return map;
	}

}
