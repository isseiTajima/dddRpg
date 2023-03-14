package com.rpg.dddrpg.domain.type;

import java.util.Objects;

/**
 * 性別区分
 */
public enum ActionType {

    attack("操作可能"),
    defence("操作不能"),
    unknown("不明");
    private final String name;

    ActionType(String name) {
        this.name = name;
    }

    public static ActionType findByName(String name) {
        for (ActionType classification : values()) {
            if (Objects.equals(classification.name, name)) {
                return classification;
            }
        }
        return ActionType.unknown;
    }

    public String getName() {
        return name;
    }

}
