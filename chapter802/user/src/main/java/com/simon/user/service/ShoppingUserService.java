package com.simon.user.service;

import com.simon.user.dao.ShoppingUserDao;
import com.simon.user.entity.ShoppingUser;
import org.apache.commons.lang.StringUtils;
import org.dromara.hmily.annotation.Hmily;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.simon.user.entity.ShoppingUser.*;

@Service
public class ShoppingUserService {

    @Autowired
    private ShoppingUserDao userDao;

    @Hmily(confirmMethod = "confirmPayment", cancelMethod = "cancelPayment")
    public int tryPayment(ShoppingUser user) {
        ShoppingUser newUser = userDao.save(user);
        return newUser.getStatus();
    }

    public boolean confirmPayment(ShoppingUser user) {
        user = userDao.getById(String.valueOf(user.getId()));
        user.setStatus(1);
        userDao.save(user);
        return Boolean.TRUE;
    }

    public boolean cancelPayment(ShoppingUser user) {
        user = userDao.getById(String.valueOf(user.getId()));
        user.setStatus(2);
        userDao.save(user);
        return Boolean.TRUE;
    }

}
