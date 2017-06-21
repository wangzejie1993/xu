package com.wangsocial.app.service;

import com.wangsocial.app.entity.PayMap;
import com.baomidou.mybatisplus.service.IService;
import com.wangsocial.app.enums.PlatformType;

/**
 * <p>
 * 订单表 服务类
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
public interface PayMapService extends IService<PayMap> {
    /**
     * 支付通知更新交易记录
     * @param tempPayCode
     * @param msg
     * @param msg2
     * @param platformType
     * @param ssn
     * @param remark2
     * @return
     */
    PayMap updatePayMapByPayCode(String tempPayCode, String msg, String msg2, PlatformType platformType, String ssn, String remark2);

	
}
