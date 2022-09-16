package com.rpg.dddRpg.domain.type;

/**
 * 職業区分
 */
public enum JobClassification {
    noJob(1, "無職") {

    },
    warrior(2, "戦士") {

    },
    wizard(3, ("魔法使い")) {

    },
    priest(4, ("僧侶")) {

    },
    unknown(null, "不明") {

    };
    private final Integer code;
    private final String name;

    JobClassification(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public boolean isNoJob() {
        return this == JobClassification.noJob;
    }

    public boolean isWarrior() {
        return this == JobClassification.warrior;
    }

    public boolean isWizard() {
        return this == JobClassification.wizard;
    }

    public boolean isPriest() {
        return this == JobClassification.priest;
    }

    public boolean isUnknown() {
        return this == JobClassification.unknown;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
