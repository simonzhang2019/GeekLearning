package com.simon.demo.dao;

import com.simon.demo.entity.ShoppingOrder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShoppingOrderMapper {

    @Insert("insert into shopping_order(`id`,`order_no`,`account_id`, `status`) values(#{data.id},#{data.orderNo},#{data.accountId},#{data.status})")
    void insert(@Param("data") ShoppingOrder data);

    @Select("select * from shopping_order where id = #{id}")
    ShoppingOrder selectById(@Param("id") Long id);

    @Select("select * from shopping_order where account_id = #{accountId}")
    ShoppingOrder selectByAccountId(@Param("accountId") Long accountId);

    @Update("update shopping_order set status = #{data.status} where id = #{data.id}")
    void update(@Param("data") ShoppingOrder data);
}
