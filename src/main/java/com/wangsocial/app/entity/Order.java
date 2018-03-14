package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_order")
public class Order {
	@TableId(value = "id")
	private String id;

	private String name;

	@TableField("create_date")
	private Date createDate;

	@TableField("end_date")
	private Date endDate;

	private String status;

	@TableField("end_date")
	private String probleOrder;

	@TableField("order_process")
	private String orderProcess;

	public String getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(String orderProcess) {
		this.orderProcess = orderProcess;
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

	public String getProbleOrder() {
		return probleOrder;
	}

	public void setProbleOrder(String probleOrder) {
		this.probleOrder = probleOrder;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
