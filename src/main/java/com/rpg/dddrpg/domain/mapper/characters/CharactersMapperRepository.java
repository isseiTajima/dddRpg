package com.rpg.dddrpg.domain.mapper.characters;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CharactersMapperRepository {

    public CharactersMapperEntity findById(String id);
    public List<CharactersMapperEntity> findAll();
    public void insert(CharactersMapperEntity entity);
    public void update(CharactersMapperEntity entity);

}
