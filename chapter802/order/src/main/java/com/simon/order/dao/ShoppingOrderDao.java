package com.simon.order.dao;

import com.simon.order.entity.ShoppingOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingOrderDao extends JpaRepository<ShoppingOrder, String> {

}
