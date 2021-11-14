package com.simon.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_accounts")
public class ShoppingUser {

    /*订单ID*/
    @Id
    @Column
    private long id;

    /*用户ID*/
    @Column(name = "account_id")
    private long accountId;

    /*用户状态*/
    @Column
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
