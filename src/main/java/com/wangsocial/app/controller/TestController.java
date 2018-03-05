package com.wangsocial.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wangsocial.app.entity.ActionResult;
import com.wangsocial.app.entity.Example;

@RestController
@RequestMapping("test")
public class TestController {
	
	@RequestMapping("getUser")
    public ActionResult getUser(){
		ActionResult result = new ActionResult();
		result.setSuccess(true);
		result.setMessage("测试");
		Example example = new Example();
		example.setID("10");
		example.setName("jack");
		example.setStatus("1111");
		result.setData(example);
        return result;
    }

}
