package com.rpg.dddRpg.domain.type;

import java.util.Objects;

/**
 * 種族区分
 */
public enum TribeClassification {

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

    TribeClassification(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static TribeClassification findByCode(Integer code) {
        for (TribeClassification classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return TribeClassification.unknown;
    }

    public boolean isHuman() {
        return this == TribeClassification.human;
    }

    public boolean isElf() {
        return this == TribeClassification.elf;
    }

    public boolean isOgre() {
        return this == TribeClassification.ogre;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

}
