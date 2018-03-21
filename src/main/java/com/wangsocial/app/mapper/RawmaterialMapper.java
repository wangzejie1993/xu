package com.wangsocial.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Rawmaterial;

/**
 * 材料 表数据库控制层接口
 */
public interface RawmaterialMapper extends BaseMapper<Rawmaterial> {

	// int insertRawmaterial(Rawmaterial rawmaterial);

	@Select("select id,name,num,dutyer,surplus,outnum,purchase_num as purchaseNum,shipment_num as shipmentNum,"
			+ " create_date as createDate,end_date as endDate,status from erp_rawmaterial where status = '1' order by create_date desc")
	List<Rawmaterial> getRawmaterialList();

	@Select("select id,name,num,dutyer,surplus,outnum,purchase_num as purchaseNum,shipment_num as shipmentNum,create_date as createDate,"
			+ "end_date as endDate,status from erp_rawmaterial where name like concat('%',#{content},'%') and status = '1' order by create_date desc")
	List<Rawmaterial> getRawmaterialListByContent(String content);

	@Select("update erp_rawmaterial set surplus = surplus - #{num},outnum = outnum + #{num},shipment_num = shipment_num + 1 "
			+ " where id = #{id}")
	void updateRawmaterialParamsById(Map<String, Object> map);
}