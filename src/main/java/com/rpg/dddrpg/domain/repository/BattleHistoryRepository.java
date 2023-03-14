package com.rpg.dddrpg.domain.repository;

import com.rpg.dddrpg.domain.model.battle.BattleHistory;

import java.util.UUID;

/**
 * 戦闘リポジトリ
 */
public interface BattleHistoryRepository {

    /**
     * 戦闘履歴をidで取得する
     *
     * @param id 戦闘履歴ID
     * @return 戦闘履歴
     */
    BattleHistory findOneById(UUID id);

    /**
     * 戦闘履歴を保存する
     *
     * @param battleHistory 戦闘履歴
     */
    void save(BattleHistory battleHistory);

}
