package com.simon.demo.controller;

import com.simon.demo.entity.ShoppingOrder;
import com.simon.demo.service.ShoppingOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/sharding")
public class ShoppingOrderController {

    @Autowired
    private ShoppingOrderService shoppingOrderService;

    @PostMapping("/insert")
    public String insert(@RequestBody ShoppingOrder data){
        try{
            shoppingOrderService.insert(data);
        }catch (Exception e){
            return "保存失败";
        }
        return "保存成功";
    }

    @GetMapping("/getById")
    public String getById(Long id){
        ShoppingOrder data = shoppingOrderService.selectById(id);
        if(data!=null){
            return data.toString();
        }
        return null;
    }

    @GetMapping("/getByAccountId")
    public String getByAccountId(Long accountId){
        ShoppingOrder data = shoppingOrderService.selectByAccountId(accountId);
        if(data!=null){
            return data.toString();
        }
        return null;
    }

    @PostMapping("/update")
    public String update(@RequestBody ShoppingOrder data){
        try{
            shoppingOrderService.update(data);
        }catch (Exception e){
            return "更新失败";
        }
        return "更新成功";
    }

}
