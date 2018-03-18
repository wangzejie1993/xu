package com.wangsocial.app.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_finished_production")
public class Finished_production {

	@TableId("id")
	private String id;

	private String name;

	@TableField("add_time")
	private Date addTime;// 入库时间

	@TableField("out_time")
	private Date outTime;// 出库时间

	@TableField("add_num")
	private String addNum;// 入库数量

	@TableField("out_num")
	private String outNum;// 出库数量

	@TableField("person_name")
	private String personName;// 加工品入库责任人

	private String other;// 其他

	private String flag;// 表区分表示

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

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		this.outTime = outTime;
	}

	public String getAddNum() {
		return addNum;
	}

	public void setAddNum(String addNum) {
		this.addNum = addNum;
	}

	public String getOutNum() {
		return outNum;
	}

	public void setOutNum(String outNum) {
		this.outNum = outNum;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
