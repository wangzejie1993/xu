package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_supplier_rawmaterial_releationship")
public class SupplierRawmaterialReleationship {

	@TableId("id")
	private String id;

	@TableField("supplier_name")
	private String supplierName;// 供货商名称

	@TableField("supplier_id")
	private String supplierId;// 供货商id

	@TableField("rawmaterial_name")
	private String rawmaterialName;// 原材料名称

	@TableField("rawmaterial_id")
	private String rawmaterialId;// 原材料id

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

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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
