package com.rpg.dddrpg.domain.mapper.enemy;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnemyMapperRepository {

    @Select("select * " +
            "from enemy " +
            "where id = #{id}")
    EnemyMapperEntity findById(@Param("id") String id);

    @Insert("insert into enemy (id,name ) values(" +
            "#{entity.id},#{entity.name} )")
    void insert(@Param("entity") EnemyMapperEntity entity);

}
