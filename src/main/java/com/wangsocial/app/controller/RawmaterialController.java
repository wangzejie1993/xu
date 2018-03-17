package com.wangsocial.app.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.Rawmaterial;
import com.wangsocial.app.service.IRawmaterialService;

/**
 * 
 * 代码生成器，参考源码测试用例：
 * 
 * /mybatis-plus/src/test/java/com/baomidou/mybatisplus/test/generator/
 * MysqlGenerator.java
 *
 */
@RestController
@RequestMapping("/rawmaterial")
public class RawmaterialController {

	@Autowired
	private IRawmaterialService rawmaterialService;

	@RequestMapping(value = "/insertRawmaterial", method = RequestMethod.POST)
	public Map<String, Object> getOrderList(Rawmaterial rawmaterial) {
		Map<String, Object> map = rawmaterialService
				.insertRawmaterial(rawmaterial);
		return map;
	}

	@RequestMapping(value = "/getRawmaterialList", method = RequestMethod.POST)
	public Map<String, Object> getRawmaterialList(String content) {
		Map<String, Object> map = rawmaterialService
				.getRawmaterialList(content);
		return map;
	}

	@RequestMapping(value = "/deleteRawmaterial", method = RequestMethod.POST)
	public Map<String, Object> deleteRawmaterial(Rawmaterial rawmaterial) {
		Map<String, Object> map = rawmaterialService
				.deleteRawmaterial(rawmaterial);
		return map;
	}

}
