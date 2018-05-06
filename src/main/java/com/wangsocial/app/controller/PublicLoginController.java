package com.wangsocial.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PublicLoginController {

	@RequestMapping(value = "/login")
	public String Print( String username,String password,String code) {
		Map<String, Object> map = new HashMap<>();
		if (username.equals("123")&&password.equals("123")) {
			return "index1";
		}
		map.put("success", "1");
		return "Public/login";
	}
	
	@RequestMapping(value = "/logout")
	public String logout() {
		return "Public/login";
	}
}
