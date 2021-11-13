package dynamic.database.service.impl;

import dynamic.database.annotation.DynamicRoutingDataSource;
import dynamic.database.bean.Cost;
import dynamic.database.mapper.CostMapper;
import dynamic.database.service.CostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CostServiceImpl implements CostService {

	@Resource
	private CostMapper costMapper;

	@Override
	public void insert(Cost cost)  {
		System.out.println("insert:" + costMapper.insert(cost));
	}

	@Override
	@DynamicRoutingDataSource("dataSource2")
	public void insert2(Cost cost)  {
		System.out.println("insert2:" + costMapper.insert(cost));
	}

}