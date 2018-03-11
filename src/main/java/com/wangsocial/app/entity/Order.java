package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("order")
public class Order {
	@TableId(value = "id")
	private String id;
	
	private String  name;
	
	@TableField(value = "create_date")
	private Date  create_date;
	
	@TableField(value = "end_date")
	private Date  end_date;
	
	private String  delete;
	
	private String proble_order;

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

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public String getProble_order() {
		return proble_order;
	}

	public void setProble_order(String proble_order) {
		this.proble_order = proble_order;
	}

	
}
