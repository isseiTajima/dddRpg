package com.rpg.dddrpg.domain.type;

import com.rpg.dddrpg.domain.model.character.PlayableCharacter;

import java.util.Objects;

/**
 * 性別区分
 */
public enum CharacterType {

    playable(1, "操作可能", PlayableCharacter.class) {

    },
    enemy(2, "敵", PlayableCharacter.class) {

    },
    unknown(null, "不明", Class.class) {

    };
    // codeは不要かも
    private final Integer code;
    private final String name;
    private final Class<?> aClass;

    CharacterType(Integer code, String name, Class<?> aClass) {
        this.code = code;
        this.name = name;
        this.aClass = aClass;
    }

    public static CharacterType findByName(String name) {
        return CharacterType.valueOf(name);
    }

    public static CharacterType findByCode(Integer code) {
        for (CharacterType classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return CharacterType.unknown;
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

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Class<?> getTypeClass() {
        return aClass;
    }
}
