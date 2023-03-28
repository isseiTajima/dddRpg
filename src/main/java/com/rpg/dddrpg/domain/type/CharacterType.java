package com.rpg.dddrpg.domain.type;

/**
 * キャラクター区分
 */
public enum CharacterType {

    playable("操作可能") {

    },
    enemy("操作不能") {

    },
    unknown("不明") {

    };
    private final String name;

    CharacterType(String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

}
