package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_task")
public class Task {

	@TableId("id")
	private String id;

	private String name;

	private String context;

	private String outcompany_hep;

	private String commiect;

	@TableField("start_time")
	private Date createDate;

	@TableField("end_time")
	private Date endDate;

	private String finished;

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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getOutcompany_hep() {
		return outcompany_hep;
	}

	public void setOutcompany_hep(String outcompany_hep) {
		this.outcompany_hep = outcompany_hep;
	}

	public String getCommiect() {
		return commiect;
	}

	public void setCommiect(String commiect) {
		this.commiect = commiect;
	}

	public String getFinished() {
		return finished;
	}

	public void setFinished(String finished) {
		this.finished = finished;
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
