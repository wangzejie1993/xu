package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 支付表
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@TableName("sps_payment")
public class Payment extends Model<Payment> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 支付名称
     */
	private String payName;
    /**
     * 支付关键字
     */
	private String payKey;
    /**
     * 支付加密数据
     */
	private String payData;
    /**
     * 回调URI
     */
	private String payURI;
    /**
     * 支付对应logo地址
     */
	private String payLogoPath;
    /**
     * 支付对应logo地址
     */
	private String pcPayLogoPath;
    /**
     * 支付对应logo地址
     */
	private String shiftPayLogoPath;
    /**
     * 是否支付平台1：支付平台；0：银行
     */
	private Integer isPlat;
    /**
     * 是否web可用 ： 0：否；1是
     */
	private Integer isWebOn;
    /**
     * 是否app可用
     */
	private Integer isAppOn;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPayName() {
		return payName;
	}

	public void setPayName(String payName) {
		this.payName = payName;
	}

	public String getPayKey() {
		return payKey;
	}

	public void setPayKey(String payKey) {
		this.payKey = payKey;
	}

	public String getPayData() {
		return payData;
	}

	public void setPayData(String payData) {
		this.payData = payData;
	}

	public String getPayURI() {
		return payURI;
	}

	public void setPayURI(String payURI) {
		this.payURI = payURI;
	}

	public String getPayLogoPath() {
		return payLogoPath;
	}

	public void setPayLogoPath(String payLogoPath) {
		this.payLogoPath = payLogoPath;
	}

	public String getPcPayLogoPath() {
		return pcPayLogoPath;
	}

	public void setPcPayLogoPath(String pcPayLogoPath) {
		this.pcPayLogoPath = pcPayLogoPath;
	}

	public String getShiftPayLogoPath() {
		return shiftPayLogoPath;
	}

	public void setShiftPayLogoPath(String shiftPayLogoPath) {
		this.shiftPayLogoPath = shiftPayLogoPath;
	}

	public Integer getIsPlat() {
		return isPlat;
	}

	public void setIsPlat(Integer isPlat) {
		this.isPlat = isPlat;
	}

	public Integer getIsWebOn() {
		return isWebOn;
	}

	public void setIsWebOn(Integer isWebOn) {
		this.isWebOn = isWebOn;
	}

	public Integer getIsAppOn() {
		return isAppOn;
	}

	public void setIsAppOn(Integer isAppOn) {
		this.isAppOn = isAppOn;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
