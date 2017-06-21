package com.wangsocial.app.service.impl;

import com.wangsocial.app.entity.Member;
import com.wangsocial.app.mapper.MemberMapper;
import com.wangsocial.app.service.MemberService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author 
 * @since 2017-06-21
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
	
}
