package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * キャラクター区分
 */
@AllArgsConstructor
@Getter
public enum CharacterType {

    playable("操作可能"),
    enemy("操作不能"),
    unknown("不明");
    private final String name;

    public static CharacterType findByName(String name) {
        return CharacterType.valueOf(name);
    }


    public boolean isPlayable() {
        return this == CharacterType.playable;
    }

    public boolean isNonPlayable() {
        return this == CharacterType.enemy;
    }

    public boolean isUnknown() {
        return this == CharacterType.unknown;
    }

}
