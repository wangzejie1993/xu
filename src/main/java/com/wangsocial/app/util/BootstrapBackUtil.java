package com.wangsocial.app.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class BootstrapBackUtil {

	public static String BackJSONMessage(boolean success,String message,Object obj) {
		Map<Object, Object> map = new HashMap<>();
		map.put("success", success);
		map.put("message", message);
		map.put("data", obj);
		return JSON.toJSONString(map);
	}
}
