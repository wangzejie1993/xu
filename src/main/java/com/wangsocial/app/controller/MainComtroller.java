package com.wangsocial.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

@Controller
public class MainComtroller {

	@RequestMapping(value = "")
	public String defaultIndex() {
		return "index1";
	}

	@RequestMapping(value = "/test")
	public String gettest() {
		return "test";
	}

	@RequestMapping(value = "/index")
	public String getindex() {
		return "index";
	}

	@RequestMapping(value = "/index1")
	public String getindex1() {
		return "index1";
	}

	@RequestMapping(value = "/Node/index")
	public String getindex3() {
		return "Node/index";
	}

	@RequestMapping(value = "/Public/login")
	public String getindex4() {
		return "Public/login";
	}

	@RequestMapping(value = "/Role/index")
	public String getindex5() {
		return "Role/index";
	}

	@RequestMapping(value = "/User/index")
	public String getindex6() {
		return "User/index";
	}

	@RequestMapping(value = "/Order/index")
	public String getindex7() {
		return "Order/index";
	}

	@RequestMapping(value = "/Customer/index")
	public String getindex8() {
		return "Customer/index";
	}

	@RequestMapping(value = "/Rawmaterial/index")
	public String getRawmaterialIndexPage() {
		return "Rawmaterial/rawIndexPage";
	}

	@RequestMapping(value = "/Supplier/index")
	public String getSupplierIndexPage() {
		return "Supplier/supIndexPage";
	}

	@RequestMapping(value = "/Production/index")
	public String getProductionIndexPage() {
		return "ProductionProcess/prodIndexPage";
	}

	@RequestMapping(value = "/Production/add")
	public String getProductionAddPage() {
		return "ProductionProcess/addProductionPage";
	}

	
	@RequestMapping(value = "/FinishedProduction/index")
	public String getFinishedProduction() {
		return "FinishedProduction/index";
	}

	@RequestMapping(value = "/OutCompany/index")
	public String getOutCompany() {
		return "OutCompany/index";
	}
	@RequestMapping(value = "/Print/index")
	public String getPrint() {
		return "Print/index";
	}
	@RequestMapping(value = "/ProductionPlan/index")
	public String getProductionPlan() {
		return "ProductionPlan/index";
	}
	@RequestMapping(value = "/ProductionTask/index")
	public String getProductionTask() {
		return "ProductionTask/index";
	}


	@RequestMapping(value = "/Stock/index")
	public String getStock() {
		return "Stock/index";
	}
	
	/**
	 * get方法请求参数
	 * 
	 * @return
	 */
	@RequestMapping(value = "/Order/search", method = RequestMethod.GET)
	public ModelAndView getindex9(int limit, int offset, String searchall) {
		ModelAndView mode = new ModelAndView("/Order/index");
		System.out.println("hello world" + limit + "分页" + offset);
		Map<Object, Object> map = new HashMap<>();
		map.put("ID", "1");
		map.put("Name", "jack");
		map.put("Status", "开启");
		JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(map));
		mode.addObject("data", map);

		return mode;
	}
}
