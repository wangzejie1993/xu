package com.wangsocial.app.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_out_company")
public class Out_company {

	@TableId("id")
	private String id;
	
	private String name;
	
	@TableField("task_name")
	private String taskName;//任务名称
	
	@TableField("task_id")
	private String taskId;//任务编号
	
	@TableField("task_time")
	private Date taskTime;//任务时间
	
	@TableField("plan_rawmaterial")
	private String planRawmaterial;//预计原材料使用量
	
	@TableField("now_rawmaterial_num")
	private String nowRawmterialNum;//现有原材料量
	
	private String append;//是否需要添加
	
	@TableField("append_num")
	private String appendNum;//添加数量
	
	@TableField("append_context")
	private String appendContext;//添置内容
	
	private String surplus;//是否剩余
	
	@TableField("surplus_num")
	private String surplusNum;//剩余数量
	
	@TableField("return")
	private String returnBl;//是否归还
	
	@TableField("return_time")
	private Date returnTime;//归还时间
	
	private String other;
	
	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

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

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public Date getTaskTime() {
		return taskTime;
	}

	public void setTaskTime(Date taskTime) {
		this.taskTime = taskTime;
	}

	public String getPlanRawmaterial() {
		return planRawmaterial;
	}

	public void setPlanRawmaterial(String planRawmaterial) {
		this.planRawmaterial = planRawmaterial;
	}

	public String getNowRawmterialNum() {
		return nowRawmterialNum;
	}

	public void setNowRawmterialNum(String nowRawmterialNum) {
		this.nowRawmterialNum = nowRawmterialNum;
	}

	public String getAppend() {
		return append;
	}

	public void setAppend(String append) {
		this.append = append;
	}

	public String getAppendNum() {
		return appendNum;
	}

	public void setAppendNum(String appendNum) {
		this.appendNum = appendNum;
	}

	public String getAppendContext() {
		return appendContext;
	}

	public void setAppendContext(String appendContext) {
		this.appendContext = appendContext;
	}

	public String getSurplus() {
		return surplus;
	}

	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getSurplusNum() {
		return surplusNum;
	}

	public void setSurplusNum(String surplusNum) {
		this.surplusNum = surplusNum;
	}

	public String getReturnBl() {
		return returnBl;
	}

	public void setReturnBl(String returnBl) {
		this.returnBl = returnBl;
	}

	public Date getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	
	
}
