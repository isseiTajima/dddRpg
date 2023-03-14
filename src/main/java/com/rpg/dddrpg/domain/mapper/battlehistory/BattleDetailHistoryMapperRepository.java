package com.rpg.dddrpg.domain.mapper.battlehistory;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.UUID;

@Mapper
public interface BattleDetailHistoryMapperRepository {

    List<BattleDetailHistoryMapperEntity> findById(UUID id);

    void insertBulk(List<BattleDetailHistoryMapperEntity> entities);

}
