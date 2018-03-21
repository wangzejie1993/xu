package com.wangsocial.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.ProductionProcessReleationship;

/**
 * 工艺 表数据库控制层接口
 */
public interface ProductionProcessMapper extends
		BaseMapper<ProductionProcessReleationship> {

	// int insertRawmaterial(Rawmaterial rawmaterial);

	@Select("select id,production_name as name,rawmaterial_name as rawmaterialName,rawmaterial_id as rawmaterial_id,"
			+ " num,work_time as workTime,create_date as createDate,end_date as endDate,status "
			+ " from erp_production_process_releationship where status = '1' order by create_date desc")
	List<ProductionProcessReleationship> getProductionList();

	@Select("select id,production_name as name,rawmaterial_name as rawmaterialName,rawmaterial_id as rawmaterial_id,"
			+ " num,work_time as workTime,create_date as createDate,end_date as endDate,status from erp_production_process_releationship"
			+ " where production_name like concat('%',#{content},'%') and status = '1' order by create_date desc")
	List<ProductionProcessReleationship> getProductionListByContent(
			String content);
}