package com.rpg.dddRpg.domain.type;

import java.util.Objects;

/**
 * 種族区分
 */
public enum RaceType {

    human(1, "人間") {

    },
    elf(2, ("エルフ")) {

    },
    ogre(3, "オーガ") {

    },
    unknown(null, "不明") {

    };
    private final Integer code;
    private final String name;

    RaceType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static RaceType findByCode(Integer code) {
        for (RaceType classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return RaceType.unknown;
    }

    public boolean isHuman() {
        return this == RaceType.human;
    }

    public boolean isElf() {
        return this == RaceType.elf;
    }

    public boolean isOgre() {
        return this == RaceType.ogre;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
