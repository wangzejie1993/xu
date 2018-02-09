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
}
