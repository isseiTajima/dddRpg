package com.rpg.dddrpg.domain.mapper.characterstatus;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterStatusMapperRepository {

    CharacterStatusMapperEntity findByCharacterId(String characterId);

    void insert(CharacterStatusMapperEntity entity);

    void update(CharacterStatusMapperEntity entity);

}
