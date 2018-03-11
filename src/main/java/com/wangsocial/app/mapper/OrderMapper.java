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
	Integer insert(Order order);

	// 删除
	Integer deleteById(String id);

	// 查看
	@Select("select id, name, create_date, end_date, delete, proble_order from oder")
	public List<Order> selectAll();

	public Order selectById(String id);

	// 编辑
	Integer updateById(Order order);

}
