package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_production_plan")
public class Production_plan {

	@TableId("id")
	private String id;

	private String name;

	@TableField("production_name")
	private String productionName;//工艺名称

	@TableField("production_id")
	private String productionId;//工艺编号

	@TableField("rawmaterialr_name")
	private String rawmaterialName;//原材料名称
	
	@TableField("rawmaterial_id")
	private String rawmaterialId;//原材料iD
	
	@TableField("plan_time")
	private String planTime;//计划时间
	
	private String judge;//是否改为分配

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

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

	

}
