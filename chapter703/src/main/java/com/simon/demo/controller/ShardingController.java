package com.simon.demo.controller;

import com.simon.demo.entity.Sharding;
import com.simon.demo.service.ShardingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sharding")
public class ShardingController {

    @Autowired
    private ShardingService shardingService;

    @PostMapping("/insert")
    public String insert(@RequestBody Sharding data){
        try{
            shardingService.insert(data);
        }catch (Exception e){
            return "保存失败";
        }
        return "保存成功";
    }

    @GetMapping("/getById")
    public String getById(Long id){
        Sharding data = shardingService.selectById(id);
        if(data!=null){
            return data.toString();
        }
        return null;
    }

}
