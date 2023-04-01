package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * フェーズ区分
 */
@AllArgsConstructor
@Getter
public enum PhaseType {

    ally("味方"),
    enemy("敵"),
    unknown("不明");
    private final String name;

    public static PhaseType findByName(String name) {
        for (PhaseType classification : values()) {
            if (Objects.equals(classification.name, name)) {
                return classification;
            }
        }
        return PhaseType.unknown;
    }

}
