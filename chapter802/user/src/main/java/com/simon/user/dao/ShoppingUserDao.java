package com.simon.user.dao;

import com.simon.user.entity.ShoppingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingUserDao extends JpaRepository<ShoppingUser, String> {

}
