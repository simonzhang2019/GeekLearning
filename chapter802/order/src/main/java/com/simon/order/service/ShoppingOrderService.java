package com.simon.order.service;

import com.simon.order.dao.ShoppingOrderDao;
import com.simon.order.remote.RemoteUserService;
import com.simon.order.entity.ShoppingOrder;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingOrderService {

    @Autowired
    private ShoppingOrderDao orderDao;
    @Autowired
    private RemoteUserService remoteUserService;

    @Hmily(confirmMethod = "confirmOrder", cancelMethod = "cancelOrder")
    public long tryCreateOrder(ShoppingOrder order){
        orderDao.save(order);
        remoteUserService.tryPayment(order.getId());
        return order.getId();
    }

    public void confirmOrder(ShoppingOrder order){
        order.setStatus(1);
        orderDao.save(order);
    }

    public void cancelOrder(ShoppingOrder order){
        order.setStatus(2);
        orderDao.save(order);
    }
}
