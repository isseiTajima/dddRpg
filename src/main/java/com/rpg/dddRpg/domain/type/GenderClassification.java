package com.rpg.dddRpg.domain.type;

import java.util.Objects;

/**
 * 性別区分
 */
public enum GenderClassification {

    man(1, "男") {

    },
    female(2, ("女")) {

    },
    unknown(null, "不明") {

    };
    private final Integer code;
    private final String name;

    GenderClassification(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static GenderClassification findByCode(Integer code) {
        for (GenderClassification classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return GenderClassification.unknown;
    }

    public boolean isMan() {
        return this == GenderClassification.man;
    }

    public boolean isFemale() {
        return this == GenderClassification.female;
    }

    public boolean isUnknown() {
        return this == GenderClassification.unknown;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
