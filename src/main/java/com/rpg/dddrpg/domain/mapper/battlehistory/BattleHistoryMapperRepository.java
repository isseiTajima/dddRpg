package com.rpg.dddrpg.domain.mapper.battlehistory;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BattleHistoryMapperRepository {

    BattleHistoryMapperEntity findById(String id);

    void insert(BattleHistoryMapperEntity entity);

}
