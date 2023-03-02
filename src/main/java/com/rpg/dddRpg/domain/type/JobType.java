package com.rpg.dddRpg.domain.type;

import java.util.Objects;

public enum JobType {
    /**
     * 職業区分
     */


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

    JobType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
        public boolean isNoJob() {
            return this == JobType.noJob;
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

        public Integer getCode() {
            return code;
        }

        public String getName() {
            return name;
        }
    public static JobType findByCode(Integer code) {
        for (JobType classification : values()) {
            if (Objects.equals(classification.code, code)) {
                return classification;
            }
        }

        return JobType.unknown;
    }
}
