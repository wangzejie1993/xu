package com.wangsocial.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.wangsocial.app.entity.Task;

public interface TaskMapper extends BaseMapper<Task> {

	@Select("SELECT id AS id,`name`,production_name AS productionName,production_id AS productionId,rawmaterialr_name AS rawmaterialName,rawmaterial_id AS rawmaterialId,plan_time AS planTime,judge FROM erp_production_plan where name like concat('%',#{content},'%')")
	List<Task> getProductionPlanListByContent(String content);
}
