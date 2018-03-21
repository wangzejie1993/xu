package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Supplier;
import com.wangsocial.app.service.ISupplierService;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/
 * MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/supplier")
public class SupplierController {

	@Autowired
	private ISupplierService supplierService;

	@RequestMapping(value = "/insertSupplier", method = RequestMethod.POST)
	public Map<String, Object> insertSupplier(Supplier supplier) {
		Map<String, Object> map = supplierService.insertSupplier(supplier);
		return map;
	}

	@RequestMapping(value = "/getSupplierList", method = RequestMethod.POST)
	public Map<String, Object> getSupplierList(String content) {
		Map<String, Object> map = supplierService.getSupplierList(content);
		return map;
	}

	@RequestMapping(value = "/deleteSupplier", method = RequestMethod.POST)
	public Map<String, Object> deleteSupplier(Supplier supplier) {
		Map<String, Object> map = supplierService.deleteSupplier(supplier);
		return map;
	}

}
