package com.rpg.dddrpg.domain.mapper.enemystatus;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EnemyStatusMapperRepository {

    @Select("select * " +
            "from enemyStatus " +
            "where enemyId = #{enemyId}")
    EnemyStatusMapperEntity findByEnemyId(@Param("enemyId") String enemyId);

    @Insert("insert into enemyStatus " +
            "(id, enemyId,level, hp ,attack ,defence ,speed) " +
            "values (" +
            "#{entity.id},#{entity.enemyId},#{entity.level},#{entity.hp}," +
            "#{entity.attack},#{entity.defence},#{entity.speed}" +
            ")")
    void insert(@Param("entity") EnemyStatusMapperEntity entity);


}
