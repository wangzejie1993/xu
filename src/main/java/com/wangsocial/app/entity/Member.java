package com.wangsocial.app.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@TableName("sps_member")
public class Member extends Model<Member> {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 用户名
     */
	private String username;
    /**
     * 用户唯一推广编码
     */
	private String userCode;
    /**
     * 用户标签
     */
	private Integer userLabel;
    /**
     * 用户密码
     */
	private String password;
    /**
     * 密码加密的盐
     */
	private String salt;
    /**
     * 用户状态：1 正常 /0 禁用
     */
	private Integer status;
    /**
     * 会员级别
     */
	private Integer grade;
    /**
     * 真实姓名
     */
	private String realName;
    /**
     * 昵称
     */
	private String nickName;
    /**
     * 用户头像
     */
	private String showImage;
    /**
     * 生日
     */
	private Long birthday;
    /**
     * 生日字符串
     */
	private String birthdayStr;
    /**
     * 性别:0 女 / 1 男
     */
	private Integer sex;
    /**
     * 邮箱
     */
	private String email;
    /**
     * 邮箱校验状态：0 未校验 / 1 校验通过
     */
	private Integer emailStatus;
    /**
     * 手机号
     */
	private String cellphone;
    /**
     * 手机号校验状态：0 未校验 / 1 校验通过
     */
	private Integer phoneStatus;
    /**
     * 电话号码
     */
	private String telephone;
    /**
     * 所在省份
     */
	private String province;
    /**
     * 所在城市
     */
	private String city;
    /**
     * 所在区县
     */
	private String country;
    /**
     * 具体详细地址
     */
	private String address;
    /**
     * 更多其他信息
     */
	private String otherInfo;
    /**
     * 添加日期:Unix时间戳
     */
	private Long createTime;
    /**
     * 最后更新日期：Unix时间戳
     */
	private Long modifyTime;
    /**
     * 证件号码
     */
	private String idCardNo;
    /**
     * 介绍人ID
     */
	private Long referee;
    /**
     * 现金账户余额
     */
	private BigDecimal amount;
    /**
     * 剩余积分
     */
	private Integer points;
    /**
     * 交易次数
     */
	private Integer orderCount;
    /**
     * 对应odoo的id
     */
	private Integer odooId;
    /**
     * 所购订单总金额
     */
	private BigDecimal orderAmount;
    /**
     * 当前等级下花费的总金额
     */
	private BigDecimal gradeAmount;
    /**
     * 会员等级改变时间
     */
	private Long gradeChangeTime;
    /**
     * 会员标记,0-普通会员,1-特殊关注会员
     */
	private Integer memberMark;
    /**
     * 会员标签
     */
	private String memberLabel;
    /**
     * 标记原因
     */
	private String labelReason;
    /**
     * 手机更改时间
     */
	private Long phoneUpdateTime;
    /**
     * 邮箱更改时间
     */
	private Long emailUpdateTime;
	private Boolean del;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getUserLabel() {
		return userLabel;
	}

	public void setUserLabel(Integer userLabel) {
		this.userLabel = userLabel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getShowImage() {
		return showImage;
	}

	public void setShowImage(String showImage) {
		this.showImage = showImage;
	}

	public Long getBirthday() {
		return birthday;
	}

	public void setBirthday(Long birthday) {
		this.birthday = birthday;
	}

	public String getBirthdayStr() {
		return birthdayStr;
	}

	public void setBirthdayStr(String birthdayStr) {
		this.birthdayStr = birthdayStr;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(Integer emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getPhoneStatus() {
		return phoneStatus;
	}

	public void setPhoneStatus(Integer phoneStatus) {
		this.phoneStatus = phoneStatus;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOtherInfo() {
		return otherInfo;
	}

	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}

	public Long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Long createTime) {
		this.createTime = createTime;
	}

	public Long getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Long modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public Long getReferee() {
		return referee;
	}

	public void setReferee(Long referee) {
		this.referee = referee;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public Integer getOdooId() {
		return odooId;
	}

	public void setOdooId(Integer odooId) {
		this.odooId = odooId;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getGradeAmount() {
		return gradeAmount;
	}

	public void setGradeAmount(BigDecimal gradeAmount) {
		this.gradeAmount = gradeAmount;
	}

	public Long getGradeChangeTime() {
		return gradeChangeTime;
	}

	public void setGradeChangeTime(Long gradeChangeTime) {
		this.gradeChangeTime = gradeChangeTime;
	}

	public Integer getMemberMark() {
		return memberMark;
	}

	public void setMemberMark(Integer memberMark) {
		this.memberMark = memberMark;
	}

	public String getMemberLabel() {
		return memberLabel;
	}

	public void setMemberLabel(String memberLabel) {
		this.memberLabel = memberLabel;
	}

	public String getLabelReason() {
		return labelReason;
	}

	public void setLabelReason(String labelReason) {
		this.labelReason = labelReason;
	}

	public Long getPhoneUpdateTime() {
		return phoneUpdateTime;
	}

	public void setPhoneUpdateTime(Long phoneUpdateTime) {
		this.phoneUpdateTime = phoneUpdateTime;
	}

	public Long getEmailUpdateTime() {
		return emailUpdateTime;
	}

	public void setEmailUpdateTime(Long emailUpdateTime) {
		this.emailUpdateTime = emailUpdateTime;
	}

	public Boolean isDel() {
		return del;
	}

	public void setDel(Boolean del) {
		this.del = del;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
