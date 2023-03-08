package com.rpg.dddRpg.domain.mapper.characters;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CharacterStatusMapperRepository {

    public void insert(CharacterStatusMapperEntity entity);

    public void update(CharacterStatusMapperEntity entity);

}
