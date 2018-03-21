package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_production_process_releationship")
public class ProductionProcessReleationship {

	@TableId("id")
	private String id;

	@TableField("production_name")
	private String name; // 工艺名称

	@TableField("rawmaterial_name")
	private String rawmaterialName;// 原材料名称

	@TableField("rawmaterial_id")
	private String rawmaterialId;// 原材料iD

	private String num;

	@TableField("work_time")
	private Date workTime;

	@TableField("create_date")
	private Date createDate;

	@TableField("end_date")
	private Date endDate;

	private String status;

	@TableField(exist = false)
	private String orderId;

	@TableField(exist = false)
	private String orderName;

	@TableField(exist = false)
	private String total;

	@TableField(exist = false)
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
