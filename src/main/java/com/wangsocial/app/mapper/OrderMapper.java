package com.wangsocial.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Order;

/**
 * Order 表数据库控制层接口
 *
 */
public interface OrderMapper extends BaseMapper<Order> {

	/*
	 * 自定义注入法
	 */
	// 增加
	@Override
	Integer insert(Order order);

	// 查看
	@Select("select id, name, create_date as createDate, end_date as endDate, status, proble_order as probleOrder,"
			+ " order_process as orderProcess from erp_order where status = '1' order by create_date desc ")
	public List<Order> selectAll();

	public Order selectById(String id);

	// 编辑
	@Override
	Integer updateById(Order order);

}
