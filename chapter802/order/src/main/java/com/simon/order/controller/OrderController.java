package com.simon.order.controller;

import com.simon.order.entity.ShoppingOrder;
import com.simon.order.service.ShoppingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ShoppingOrderService orderService;

    @PostMapping("/create")
    public String create(@RequestBody ShoppingOrder data){
        try{
            orderService.tryCreateOrder(data);
        }catch (Exception e){
            return "保存失败";
        }
        return "保存成功";
    }
}
