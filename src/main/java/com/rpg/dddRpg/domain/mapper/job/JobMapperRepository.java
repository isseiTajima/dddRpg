package com.rpg.dddRpg.domain.mapper.job;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobMapperRepository {

    public JobMapperEntity findById(String id);

}
