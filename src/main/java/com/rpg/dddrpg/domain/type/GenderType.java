package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性別区分
 */
@AllArgsConstructor
@Getter
public enum GenderType {

    man("男"),
    female("女"),
    unknown("不明");
    private final String name;

    public static GenderType findByName(String name) {
        return GenderType.valueOf(name);
    }

    public boolean isMan() {
        return this == GenderType.man;
    }

    public boolean isFemale() {
        return this == GenderType.female;
    }

    public boolean isUnknown() {
        return this == GenderType.unknown;
    }

}
