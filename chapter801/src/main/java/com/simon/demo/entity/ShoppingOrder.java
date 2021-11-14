package com.simon.demo.entity;

import lombok.Data;

@Data
public class ShoppingOrder {

    /*订单ID*/
    private long id;

    /*订单号*/
    private String orderNo;

    /*用户ID*/
    private long accountId;

    /*订单状态*/
    private int status;

    // 其他字段省略

}
