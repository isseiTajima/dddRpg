package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.Random;

/**
 * 行動区分
 */
@AllArgsConstructor
@Getter
public enum ActionType {

    attack("攻撃"),
    defence("防御"),
    unknown("不明");
    private final String name;

    public static ActionType findByName(String name) {
        for (ActionType classification : values()) {
            if (Objects.equals(classification.name, name)) {
                return classification;
            }
        }
        return ActionType.unknown;
    }

    /**
     * ランダムにタイプを返却します
     *
     * @return 行動タイプ
     */
    public static ActionType randomType() {
        var random = new Random();
        var next = random.nextBoolean();
        if (next) {
            return ActionType.attack;
        } else {
            return ActionType.defence;
        }
    }

    public boolean isAttack() {
        return this == ActionType.attack;
    }

    public boolean isDefence() {
        return this == ActionType.defence;
    }
}
