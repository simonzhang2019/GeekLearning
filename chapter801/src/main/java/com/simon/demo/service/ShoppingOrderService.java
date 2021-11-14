package com.simon.demo.service;

import com.simon.demo.dao.ShoppingOrderMapper;
import com.simon.demo.entity.ShoppingOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingOrderService {

    @Autowired
    private ShoppingOrderMapper shoppingOrderMapper;

    public void insert(ShoppingOrder data){
        shoppingOrderMapper.insert(data);
    }

    public ShoppingOrder selectById(Long id){
        return shoppingOrderMapper.selectById(id);
    }

    public ShoppingOrder selectByAccountId(Long accountId){
        return shoppingOrderMapper.selectByAccountId(accountId);
    }

    public void update(ShoppingOrder data){
        shoppingOrderMapper.update(data);
    }

}
