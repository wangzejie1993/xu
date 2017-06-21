package com.wangsocial.app.service.impl;

import com.wangsocial.app.entity.Payment;
import com.wangsocial.app.mapper.PaymentMapper;
import com.wangsocial.app.service.PaymentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付表 服务实现类
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment> implements PaymentService {
	
}
