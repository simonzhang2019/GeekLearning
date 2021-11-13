package com.simon.demo.service;

import com.simon.demo.dao.ShardingMapper;
import com.simon.demo.entity.Sharding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShardingService {

    @Autowired
    private ShardingMapper shardingMapper;

    public void insert(Sharding data){
        shardingMapper.insert(data);
    }

    public Sharding selectById(Long id){
        return shardingMapper.selectById(id);
    }

}
