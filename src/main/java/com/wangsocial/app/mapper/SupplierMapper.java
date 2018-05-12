package com.wangsocial.app.mapper;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Supplier;

/**
 * 材料 表数据库控制层接口
 */
public interface SupplierMapper extends BaseMapper<Supplier> {

	// int insertRawmaterial(Rawmaterial rawmaterial);

	@Select("select id,name,company,address,create_date as createDate,end_date as endDate,status "
			+ " from erp_supplier where status = '1' order by create_date desc")
	List<Supplier> getSupplierList();

	@Select("select id,name,company,address,create_date as createDate,end_date as endDate,status from erp_supplier "
			+ " where name like concat('%',#{content},'%') or company like concat('%',#{content},'%') "
			+ " or address like concat('%',#{content},'%') and status = '1' order by create_date desc")
	List<Supplier> getSupplierListByContent(String content);
	
	@Override
	Supplier selectById(Serializable id);
	
	@Override
	Integer updateById(Supplier entity);
}