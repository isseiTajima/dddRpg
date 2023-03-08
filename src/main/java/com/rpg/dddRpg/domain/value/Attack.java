package com.rpg.dddRpg.domain.value;

import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;

import java.util.Objects;
import java.util.Random;

/**
 * 力
 */

public class Attack {
    Integer value;

    private Attack(Integer value) {
        this.value = value;
    }

    public static Attack of(Integer value) {
        return new Attack(value);
    }

    public static Attack initial(GenderType genderType, RaceType raceType,
                                 JobType jobType) {
        // 初期値
        Integer attackValue = 1;
        // 性別による加算値を取得
        Integer addOfGenderValue = calcAddValueOfGender(genderType);
        // 種族による加算値を取得
        Integer addOfRaceValue = calcAddValueOfRace(raceType);
        // 職業による加算値を取得
        Integer addOfJobValue = calcAddValueOfJob(jobType);

        // 加算値の合計を初期値とする
        return new Attack(attackValue + addOfGenderValue + addOfRaceValue + addOfJobValue);
    }

    static Integer calcAddValueOfRace(RaceType raceType) {
        // 種族の初期値を取得
        var attackInitialValue = AttackInitialOfRace.findByType(raceType);
        Integer diffValue = calcRandomDiffValue(attackInitialValue.getMinValue(),
                attackInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return attackInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfGender(GenderType genderType) {

        // 性別の初期値を取得
        var attackInitialValue = AttackInitialOfGender.findByType(genderType);
        Integer diffValue = calcRandomDiffValue(attackInitialValue.getMinValue(),
                attackInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return attackInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfJob(JobType jobType) {

        // 性別の初期値を取得
        var attackInitialValue = AttackInitialOfJob.findByType(jobType);
        Integer diffValue = calcRandomDiffValue(attackInitialValue.getMinValue(),
                attackInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return attackInitialValue.getMinValue() + diffValue;
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

    enum AttackInitialOfGender {
        man(GenderType.man, 10, 13),
        female(GenderType.female, 8, 12),
        unknown(GenderType.unknown, null, null);

        private final GenderType genderType;
        private final Integer minValue;
        private final Integer maxValue;

        AttackInitialOfGender(GenderType genderType, Integer minValue, Integer maxValue) {
            this.genderType = genderType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static AttackInitialOfGender findByType(GenderType genderType) {
            for (AttackInitialOfGender type : values()) {
                if (Objects.equals(type.genderType, genderType)) {
                    return type;
                }
            }

            return AttackInitialOfGender.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum AttackInitialOfRace {
        human(RaceType.human, 5, 8),
        elf(RaceType.elf, 3, 5),
        ogre(RaceType.ogre, 8, 10),
        unknown(RaceType.unknown, null, null);

        private final RaceType raceType;
        private final Integer minValue;
        private final Integer maxValue;

        AttackInitialOfRace(RaceType raceType, Integer minValue, Integer maxValue) {
            this.raceType = raceType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static AttackInitialOfRace findByType(RaceType raceType) {
            for (AttackInitialOfRace type : values()) {
                if (Objects.equals(type.raceType, raceType)) {
                    return type;
                }
            }

            return AttackInitialOfRace.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum AttackInitialOfJob {
        hero(JobType.hero, 8, 12),
        warrior(JobType.warrior, 10, 15),
        wizard(JobType.wizard, 5, 8),
        priest(JobType.priest, 5, 8),
        unknown(JobType.unknown, null, null);

        private final JobType jobType;
        private final Integer minValue;
        private final Integer maxValue;

        AttackInitialOfJob(JobType jobType, Integer minValue, Integer maxValue) {
            this.jobType = jobType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static AttackInitialOfJob findByType(JobType jobType) {
            for (AttackInitialOfJob type : values()) {
                if (Objects.equals(type.jobType, jobType)) {
                    return type;
                }
            }

            return AttackInitialOfJob.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }
}


