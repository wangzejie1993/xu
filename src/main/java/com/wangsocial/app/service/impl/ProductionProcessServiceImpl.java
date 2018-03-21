package com.wangsocial.app.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.wangsocial.app.entity.Order;
import com.wangsocial.app.entity.OrderProductionReleation;
import com.wangsocial.app.entity.ProductionProcessReleationship;
import com.wangsocial.app.mapper.OrderMapper;
import com.wangsocial.app.mapper.OrderProductionReleationMapper;
import com.wangsocial.app.mapper.ProductionProcessMapper;
import com.wangsocial.app.mapper.RawmaterialMapper;
import com.wangsocial.app.service.IProductionProcessService;

@Service
public class ProductionProcessServiceImpl extends
		ServiceImpl<ProductionProcessMapper, ProductionProcessReleationship>
		implements IProductionProcessService {

	private final Log LOGGER = LogFactory.getLog(this.getClass());

	@Autowired
	private RawmaterialMapper rawmaterialMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderProductionReleationMapper opMapper;

	@Transactional
	@Override
	public Map<String, Object> insertProduction(
			ProductionProcessReleationship dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(dto.getName())
				|| StringUtils.isBlank(dto.getNum())
				|| StringUtils.isBlank(dto.getRawmaterialId())
				|| StringUtils.isBlank(dto.getRawmaterialName())
				|| StringUtils.isBlank(dto.getTime())) {
			map.put("ret", -1);
			map.put("msg", "有未填写的材料信息");
			return map;
		}
		try {
			// 物料表数据更新，数量，出货次数，
			// Rawmaterial rawmaterial = new Rawmaterial();
			// rawmaterial.setId(dto.getRawmaterialId());
			// int total = Integer.parseInt(dto.getTotal());
			// int num = Integer.parseInt(dto.getNum());
			// rawmaterial.setSurplus(String.valueOf(total - num));
			// rawmaterial.setOutnum(dto.getNum());
			Map<String, Object> rawMap = new HashMap<String, Object>();
			rawMap.put("id", dto.getRawmaterialId());
			rawMap.put("num", dto.getNum());
			rawmaterialMapper.updateRawmaterialParamsById(rawMap);

			// 添加工艺表信息
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Long time = new Long(dto.getTime());
			String d = format.format(time);
			Date date = format.parse(d);
			String productionId = UUID.randomUUID().toString().replace("-", "");
			dto.setId(productionId);
			dto.setStatus("1");
			dto.setWorkTime(date);
			int flag = baseMapper.insert(dto);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "添加工艺表信息失败");
				return map;
			}

			// opMapper 添加订单与 工艺关联关系
			OrderProductionReleation opr = new OrderProductionReleation();
			opr.setId(UUID.randomUUID().toString().replace("-", ""));
			opr.setOrderId(dto.getOrderId());
			opr.setOrderName(dto.getOrderName());
			opr.setProductionId(productionId);
			opr.setProductionName(dto.getName());
			int opFlag = opMapper.insert(opr);
			if (opFlag != 1) {
				map.put("ret", -1);
				map.put("msg", "添加 订单与工艺关联关系失败");
				return map;
			}

			// 更新订单状态
			Order order = new Order();
			order.setId(dto.getOrderId());
			order.setOrderProcess("2");
			int oFlag = orderMapper.updateById(order);
			if (oFlag != 1) {
				map.put("ret", -1);
				map.put("msg", "更新订单状态失败");
				return map;
			}
		} catch (Exception e) {
			LOGGER.error(e);
			map.put("ret", -1);
			map.put("msg", "程序出错");
			return map;
		}

		map.put("ret", 1);
		map.put("msg", "制定成功");
		return map;
	}

	@Override
	public Map<String, Object> getProductionList(String content) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<ProductionProcessReleationship> list = new ArrayList<ProductionProcessReleationship>();
		try {
			if (StringUtils.isBlank(content)) {
				list = baseMapper.getProductionList();
			} else {
				list = baseMapper.getProductionListByContent(content);
			}

		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，查询物料失败");
			return map;
		}

		map.put("list", list);
		map.put("ret", 1);
		map.put("msg", "获取成功");
		return map;
	}

	@Override
	public Map<String, Object> deleteProduction(
			ProductionProcessReleationship dto) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isBlank(dto.getId())) {
			map.put("ret", -1);
			map.put("msg", "id不能为空");
			return map;
		}
		try {
			dto.setStatus("0");// 逻辑删除
			int flag = baseMapper.updateById(dto);
			if (flag != 1) {
				map.put("ret", -1);
				map.put("msg", "删除失败");
				return map;
			}
		} catch (Exception e) {
			map.put("ret", -1);
			map.put("msg", "程序出错，删除失败");
			return map;
		}
		map.put("ret", 1);
		map.put("msg", "删除成功");
		return map;
	}

}
