package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 系统参数表
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@TableName("sps_sys_config")
public class SysConfig extends Model<SysConfig> {

    private static final long serialVersionUID = 1L;

    /**
     * 参数名
     */
	private String sysKey;
    /**
     * 参数值
     */
	private String sysValue;
    /**
     * 修改日期
     */
	private Long modifyTime;
    /**
     * 修改人
     */
	private Long accountId;
    /**
     * 是否缓存，true为是，false不是，默认false
     */
	private Integer isCache;
    /**
     * 参数描述
     */
	private String description;
    /**
     * 字典对应的操作
     */
	private String operator;


	public String getSysKey() {
		return sysKey;
	}

	public void setSysKey(String sysKey) {
		this.sysKey = sysKey;
	}

	public String getSysValue() {
		return sysValue;
	}

	public void setSysValue(String sysValue) {
		this.sysValue = sysValue;
	}

	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Integer getIsCache() {
		return isCache;
	}

	public void setIsCache(Integer isCache) {
		this.isCache = isCache;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Override
	protected Serializable pkVal() {
		return this.sysKey;
	}

}
