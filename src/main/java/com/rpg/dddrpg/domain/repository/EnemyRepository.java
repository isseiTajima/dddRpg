package com.rpg.dddrpg.domain.repository;

import com.rpg.dddrpg.domain.model.enemy.Enemy;

import java.util.UUID;

/**
 * 敵リポジトリ
 */
public interface EnemyRepository {

    /**
     * 敵をidで取得する
     *
     * @param id 敵ID
     * @return 敵
     */
    Enemy findOneById(UUID id);

    /**
     * 敵を保存する
     *
     * @param enemy 敵
     */
    void save(Enemy enemy);

}
