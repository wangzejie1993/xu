package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_rawmaterial")
public class Rawmaterial {

	@TableId("id")
	private String id;

	private String name;

	private String num;// 材料数量

	private String dutyer;// 负责人

	private String surplus;//剩余数量
	
	private String outNum;//出货数量
	
	private String purchaseNum;//购货次数
	
	private String shipmentNum;//出货次数

	@TableField("create_date")
	private Date createDate;

	@TableField("end_date")
	private Date endDate;
	
	private String status;

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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDutyer() {
		return dutyer;
	}

	public void setDutyer(String dutyer) {
		this.dutyer = dutyer;
	}

	public String getSurplus() {
		return surplus;
	}

	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getPurchaseNum() {
		return purchaseNum;
	}

	public void setPurchaseNum(String purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

	public String getShipmentNum() {
		return shipmentNum;
	}

	public void setShipmentNum(String shipmentNum) {
		this.shipmentNum = shipmentNum;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
