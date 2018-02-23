package com.wangsocial.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempComtroller {

	@RequestMapping(value="/test")
	public String gettest() {
		return "test";
	}
	@RequestMapping(value="/index")
	public String getindex() {
		return "index";
	}
	@RequestMapping(value="/index1")
	public String getindex1() {
		return "index1";
	}
	@RequestMapping(value="/Node/index")
	public String getindex3() {
		return "Node/index";
	}
	@RequestMapping(value="/Public/login")
	public String getindex4() {
		return "Public/login";
	}
	@RequestMapping(value="/Role/index")
	public String getindex5() {
		return "Role/index";
	}
	@RequestMapping(value="/User/index")
	public String getindex6() {
		return "User/index";
	}
}
