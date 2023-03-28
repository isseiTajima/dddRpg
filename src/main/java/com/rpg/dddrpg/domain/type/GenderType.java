package com.rpg.dddrpg.domain.type;

/**
 * 性別区分
 */
public enum GenderType {

    man("男"),
    female("女"),
    unknown("不明");
    private final String name;

    GenderType(String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }
}
