package com.rpg.dddrpg.domain.type;

import java.util.Objects;

/**
 * フェーズ区分
 */
public enum FhaseType {

    ally("味方"),
    enemy("敵"),
    unknown("不明");
    private final String name;

    FhaseType(String name) {
        this.name = name;
    }

    public static FhaseType findByName(String name) {
        for (FhaseType classification : values()) {
            if (Objects.equals(classification.name, name)) {
                return classification;
            }
        }
        return FhaseType.unknown;
    }


    public String getName() {
        return name;
    }

}
