package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("erp_print")
public class PrintCQ {

	@TableId("id")
	private String id;

	private String name;

	private String print_time;// 印染时间

	private String print_num;// 印染数量

	private String print_name;// 印染企业

	private String print_id;// 印染企业

	private String other;// 其他

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

	public String getPrint_time() {
		return print_time;
	}

	public void setPrint_time(String print_time) {
		this.print_time = print_time;
	}

	public String getPrint_num() {
		return print_num;
	}

	public void setPrint_num(String print_num) {
		this.print_num = print_num;
	}

	public String getPrint_name() {
		return print_name;
	}

	public void setPrint_name(String print_name) {
		this.print_name = print_name;
	}

	public String getPrint_id() {
		return print_id;
	}

	public void setPrint_id(String print_id) {
		this.print_id = print_id;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
