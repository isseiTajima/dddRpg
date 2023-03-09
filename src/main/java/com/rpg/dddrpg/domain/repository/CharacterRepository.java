package com.rpg.dddrpg.domain.repository;

import com.rpg.dddrpg.domain.model.character.Character;

import java.util.UUID;

/**
 * キャラクターリポジトリ
 */
public interface CharacterRepository {

    /**
     * キャラクターをidで取得する
     *
     * @param id キャラクターID
     * @return キャラクター
     */
    Character findOneById(UUID id);

    /**
     * キャラクターを保存する
     *
     * @param character キャラクター
     */
    void save(Character character);

}
