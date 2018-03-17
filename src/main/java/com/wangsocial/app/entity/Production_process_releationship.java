package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_production_process_releationship")
public class Production_process_releationship {

	@TableId("id")
	private String id;

	private String name;
	
	private String productionName;//工艺名称

	private String productionId;//工艺编号

	private String rawmaterialName;//原材料名称
	
	private String rawmaterialId;//原材料iD

	private String num;

	private String address;

	@TableField("work_time")
	private Date workTime;

	@TableField("create_date")
	private Date createDate;
	
	@TableField("end_date")
	private Date endDate;

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

	public String getProductionName() {
		return productionName;
	}

	public void setProductionName(String productionName) {
		this.productionName = productionName;
	}

	public String getProductionId() {
		return productionId;
	}

	public void setProductionId(String productionId) {
		this.productionId = productionId;
	}

	public String getRawmaterialName() {
		return rawmaterialName;
	}

	public void setRawmaterialName(String rawmaterialName) {
		this.rawmaterialName = rawmaterialName;
	}

	public String getRawmaterialId() {
		return rawmaterialId;
	}

	public void setRawmaterialId(String rawmaterialId) {
		this.rawmaterialId = rawmaterialId;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Date getWorkTime() {
		return workTime;
	}

	public void setWorkTime(Date workTime) {
		this.workTime = workTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
