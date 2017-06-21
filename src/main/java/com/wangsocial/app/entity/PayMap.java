package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@TableName("sps_pay_map")
public class PayMap extends Model<PayMap> {

    private static final long serialVersionUID = 1L;

    /**
     * 订单ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 所属订单ID
     */
	private Long orderId;
    /**
     * 所属订单code
     */
	private String orderCode;
    /**
     * 临时支付号ID
     */
	private String tempPayCode;
    /**
     * 所属平台
     */
	private String platform;
    /**
     * 支付所生成的请求信息
     */
	private String payParams;
    /**
     * 支付后回调时的详细信息
     */
	private String retMsg;
    /**
     * 备用消息
     */
	private String retMsg2;
    /**
     * 是否已支付0否；1是
     */
	private String isPaid;
	private String remark;
    /**
     * 交易流水号
     */
	private String swiftNumber;
    /**
     * 交易意图：支付订单，补齐差价
     */
	private String payPurpose;
    /**
     * orderId 所在的表 
     */
	private String idBelongsTo;
    /**
     * 本次支付所使用的现金账户金额，sps_order表中有该字段，所以普通订单支付时此字段为空
     */
	private BigDecimal cashAmt;
	private String remark2;
    /**
     * 通知回调时间
     */
	@TableField("notify_time")
	private Long notifyTime;
    /**
     * 支付请求业务来源
     */
	private String requestBiz;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getTempPayCode() {
		return tempPayCode;
	}

	public void setTempPayCode(String tempPayCode) {
		this.tempPayCode = tempPayCode;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPayParams() {
		return payParams;
	}

	public void setPayParams(String payParams) {
		this.payParams = payParams;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public String getRetMsg2() {
		return retMsg2;
	}

	public void setRetMsg2(String retMsg2) {
		this.retMsg2 = retMsg2;
	}

	public String getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(String isPaid) {
		this.isPaid = isPaid;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public String getPayPurpose() {
		return payPurpose;
	}

	public void setPayPurpose(String payPurpose) {
		this.payPurpose = payPurpose;
	}

	public String getIdBelongsTo() {
		return idBelongsTo;
	}

	public void setIdBelongsTo(String idBelongsTo) {
		this.idBelongsTo = idBelongsTo;
	}

	public BigDecimal getCashAmt() {
		return cashAmt;
	}

	public void setCashAmt(BigDecimal cashAmt) {
		this.cashAmt = cashAmt;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public Long getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(Long notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getRequestBiz() {
		return requestBiz;
	}

	public void setRequestBiz(String requestBiz) {
		this.requestBiz = requestBiz;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
