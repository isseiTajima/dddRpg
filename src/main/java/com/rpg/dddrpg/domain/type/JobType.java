package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JobType {
    /**
     * 職業区分
     */
    hero("勇者") {

    },
    warrior("戦士") {

    },
    wizard("魔法使い") {

    },
    priest("僧侶") {

    },
    unknown("不明") {

    };
    private final String name;

    public static JobType findByName(String name) {
        return JobType.valueOf(name);
    }

    public boolean isNoJob() {
        return this == JobType.hero;
    }

    public boolean isWarrior() {
        return this == JobType.warrior;
    }

    public boolean isWizard() {
        return this == JobType.wizard;
    }

    public boolean isPriest() {
        return this == JobType.priest;
    }

    public boolean isUnknown() {
        return this == JobType.unknown;
    }

    public String getName() {
        return name;
    }
}
