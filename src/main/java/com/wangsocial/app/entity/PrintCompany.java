package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_print_company")
public class PrintCompany {
	private String id;

	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
