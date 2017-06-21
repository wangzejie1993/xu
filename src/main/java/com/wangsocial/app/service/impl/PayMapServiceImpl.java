package com.wangsocial.app.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.wangsocial.app.common.exception.BusinessException;
import com.wangsocial.app.entity.PayMap;
import com.wangsocial.app.enums.PlatformType;
import com.wangsocial.app.mapper.PayMapMapper;
import com.wangsocial.app.service.PayMapService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.util.DateUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@Service
public class PayMapServiceImpl extends ServiceImpl<PayMapMapper, PayMap> implements PayMapService {

    private static Logger logger = LoggerFactory.getLogger(PayMapService.class);
    @Autowired
    private PayMapMapper payMapMapper;

    @Override
    public PayMap updatePayMapByPayCode(String tempPayCode, String msg, String msg2, PlatformType platformType, String ssn, String remark2) {
        PayMap param = new PayMap();
        param.setTempPayCode(tempPayCode);
        param.setPlatform(platformType.value());
        List<PayMap> payMaps = payMapMapper.selectList(new EntityWrapper<PayMap>());
        Assert.notNull(payMaps);
        if (payMaps != null && !payMaps.isEmpty()) {
            PayMap payMap = payMaps.get(0);
            payMap.setRetMsg(msg);
            payMap.setRetMsg2(msg2);
            payMap.setSwiftNumber(ssn);
            payMap.setIsPaid("1");
            payMap.setNotifyTime(DateUtils.getUnixTimestamp());
            if (StringUtils.isNotBlank(remark2)) {
                payMap.setRemark2(remark2);
            }
            payMapMapper.updateById(payMap);
            return payMap;
        } else {
            throw new BusinessException("数据库异常，交易记录查询为Null");
        }
    }
}
