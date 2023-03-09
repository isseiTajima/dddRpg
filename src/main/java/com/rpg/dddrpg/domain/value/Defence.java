package com.rpg.dddrpg.domain.value;

import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;

import java.util.Objects;
import java.util.Random;

/**
 * 防御
 */

public class Defence {
    Integer value;

    private Defence(Integer value) {
        this.value = value;
    }

    public static Defence of(Integer value) {
        return new Defence(value);
    }

    public static Defence initial(GenderType genderType, RaceType raceType,
                                  JobType jobType) {
        // 初期値
        Integer defenceValue = 1;
        // 性別による加算値を取得
        Integer addOfGenderValue = calcAddValueOfGender(genderType);
        // 種族による加算値を取得
        Integer addOfRaceValue = calcAddValueOfRace(raceType);
        // 職業による加算値を取得
        Integer addOfJobValue = calcAddValueOfJob(jobType);

        // 加算値の合計を初期値とする
        return new Defence(defenceValue + addOfGenderValue + addOfRaceValue + addOfJobValue);
    }

    static Integer calcAddValueOfRace(RaceType raceType) {
        // 種族の初期値を取得
        var defenceInitialValue = DefenceInitialOfRace.findByType(raceType);
        Integer diffValue = calcRandomDiffValue(defenceInitialValue.getMinValue(),
                defenceInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return defenceInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfGender(GenderType genderType) {

        // 性別の初期値を取得
        var defenceInitialValue = DefenceInitialOfGender.findByType(genderType);
        Integer diffValue = calcRandomDiffValue(defenceInitialValue.getMinValue(),
                defenceInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return defenceInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfJob(JobType jobType) {

        // 性別の初期値を取得
        var defenceInitialValue = DefenceInitialOfJob.findByType(jobType);
        Integer diffValue = calcRandomDiffValue(defenceInitialValue.getMinValue(),
                defenceInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return defenceInitialValue.getMinValue() + diffValue;
    }

    static Integer calcRandomDiffValue(Integer minValue, Integer maxValue) {

        // 乱数を生成
        Random random = new Random();
        Integer randomValue = random.nextInt(minValue,
                maxValue);

        // 範囲内の乱数と最小値の差を求める
        return randomValue - minValue;

    }

    public Integer getValue() {
        return this.value;
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    enum DefenceInitialOfGender {
        man(GenderType.man, 10, 13),
        female(GenderType.female, 8, 12),
        unknown(GenderType.unknown, null, null);

        private final GenderType genderType;
        private final Integer minValue;
        private final Integer maxValue;

        DefenceInitialOfGender(GenderType genderType, Integer minValue, Integer maxValue) {
            this.genderType = genderType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static DefenceInitialOfGender findByType(GenderType genderType) {
            for (DefenceInitialOfGender type : values()) {
                if (Objects.equals(type.genderType, genderType)) {
                    return type;
                }
            }

            return DefenceInitialOfGender.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum DefenceInitialOfRace {
        human(RaceType.human, 5, 8),
        elf(RaceType.elf, 3, 5),
        ogre(RaceType.ogre, 8, 10),
        unknown(RaceType.unknown, null, null);

        private final RaceType raceType;
        private final Integer minValue;
        private final Integer maxValue;

        DefenceInitialOfRace(RaceType raceType, Integer minValue, Integer maxValue) {
            this.raceType = raceType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static DefenceInitialOfRace findByType(RaceType raceType) {
            for (DefenceInitialOfRace type : values()) {
                if (Objects.equals(type.raceType, raceType)) {
                    return type;
                }
            }

            return DefenceInitialOfRace.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum DefenceInitialOfJob {
        hero(JobType.hero, 8, 12),
        warrior(JobType.warrior, 10, 15),
        wizard(JobType.wizard, 5, 8),
        priest(JobType.priest, 5, 8),
        unknown(JobType.unknown, null, null);

        private final JobType jobType;
        private final Integer minValue;
        private final Integer maxValue;

        DefenceInitialOfJob(JobType jobType, Integer minValue, Integer maxValue) {
            this.jobType = jobType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static DefenceInitialOfJob findByType(JobType jobType) {
            for (DefenceInitialOfJob type : values()) {
                if (Objects.equals(type.jobType, jobType)) {
                    return type;
                }
            }

            return DefenceInitialOfJob.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }
}


