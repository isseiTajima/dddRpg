package com.rpg.dddrpg.domain.repository;

import com.rpg.dddrpg.domain.model.Job;

import java.util.UUID;

/**
 * 職業リポジトリ
 */
public interface JobRepository {

    /**
     * をidで取得する
     *
     * @param id キャラクターID
     * @return キャラクター
     */
    Job findById(UUID id);


}
