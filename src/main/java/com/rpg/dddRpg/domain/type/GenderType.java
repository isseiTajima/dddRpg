package com.rpg.dddRpg.domain.type;

import java.util.Objects;

/**
 * 性別区分
 */
public enum GenderType {

    man(1, "男") {

    },
    female(2, ("女")) {

    },
    unknown(null, "不明") {

    };
    private final Integer code;
    private final String name;

    GenderType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static GenderType findByCode(Integer code) {
        for (GenderType classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return GenderType.unknown;
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

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
