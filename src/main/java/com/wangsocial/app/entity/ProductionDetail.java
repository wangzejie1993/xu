package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_production_detail")
public class ProductionDetail {

	@TableId("id")
	private String id;

	private String materialName;// 材料名称

	private String specif;// 规格

	private String weigth;// 重量

	private String other;// 其他

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMaterialName() {
		return materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public String getSpecif() {
		return specif;
	}

	public void setSpecif(String specif) {
		this.specif = specif;
	}

	public String getWeigth() {
		return weigth;
	}

	public void setWeigth(String weigth) {
		this.weigth = weigth;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
