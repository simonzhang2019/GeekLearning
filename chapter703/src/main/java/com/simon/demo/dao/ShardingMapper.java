package com.simon.demo.dao;

import com.simon.demo.entity.Sharding;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShardingMapper {

    @Insert("insert into tbl(`id`,`name`,`description`) values(#{data.id},#{data.name},#{data.description})")
    void insert(@Param("data") Sharding data);

    @Select("select * from tbl where id = #{id}")
    Sharding selectById(@Param("id") Long id);

}
