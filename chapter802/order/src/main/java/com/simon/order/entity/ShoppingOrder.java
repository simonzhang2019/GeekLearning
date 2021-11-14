package com.simon.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_order")
public class ShoppingOrder {

    /*订单ID*/
    @Id
    @Column
    private long id;

    /*订单号*/
    @Column(name = "order_no")
    private String orderNo;

    /*用户ID*/
    @Column(name = "account_id")
    private long accountId;

    /*订单状态*/
    @Column(name = "status")
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    // 其他字段省略

}
