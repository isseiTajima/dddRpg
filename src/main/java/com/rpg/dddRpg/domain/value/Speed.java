package com.rpg.dddRpg.domain.value;

import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;

import java.util.Objects;
import java.util.Random;

/**
 * 速さ
 */

public class Speed {
    Integer value;

    private Speed(Integer value) {
        this.value = value;
    }

    public static Speed of(Integer value) {
        return new Speed(value);
    }

    public static Speed initial(GenderType genderType, RaceType raceType,
                                JobType jobType) {
        // 初期値
        Integer speedValue = 1;
        // 性別による加算値を取得
        Integer addOfGenderValue = calcAddValueOfGender(genderType);
        // 種族による加算値を取得
        Integer addOfRaceValue = calcAddValueOfRace(raceType);
        // 職業による加算値を取得
        Integer addOfJobValue = calcAddValueOfJob(jobType);

        // 加算値の合計を初期値とする
        return new Speed(speedValue + addOfGenderValue + addOfRaceValue + addOfJobValue);
    }

    static Integer calcAddValueOfRace(RaceType raceType) {
        // 種族の初期値を取得
        var speedInitialValue = SpeedInitialOfRace.findByType(raceType);
        Integer diffValue = calcRandomDiffValue(speedInitialValue.getMinValue(),
                speedInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return speedInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfGender(GenderType genderType) {

        // 性別の初期値を取得
        var speedInitialValue = SpeedInitialOfGender.findByType(genderType);
        Integer diffValue = calcRandomDiffValue(speedInitialValue.getMinValue(),
                speedInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return speedInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfJob(JobType jobType) {

        // 性別の初期値を取得
        var speedInitialValue = SpeedInitialOfJob.findByType(jobType);
        Integer diffValue = calcRandomDiffValue(speedInitialValue.getMinValue(),
                speedInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return speedInitialValue.getMinValue() + diffValue;
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

    enum SpeedInitialOfGender {
        man(GenderType.man, 5, 8),
        female(GenderType.female, 4, 9),
        unknown(GenderType.unknown, null, null);

        private final GenderType genderType;
        private final Integer minValue;
        private final Integer maxValue;

        SpeedInitialOfGender(GenderType genderType, Integer minValue, Integer maxValue) {
            this.genderType = genderType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static SpeedInitialOfGender findByType(GenderType genderType) {
            for (SpeedInitialOfGender type : values()) {
                if (Objects.equals(type.genderType, genderType)) {
                    return type;
                }
            }

            return SpeedInitialOfGender.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum SpeedInitialOfRace {
        human(RaceType.human, 5, 8),
        elf(RaceType.elf, 8, 12),
        ogre(RaceType.ogre, 3, 6),
        unknown(RaceType.unknown, null, null);

        private final RaceType raceType;
        private final Integer minValue;
        private final Integer maxValue;

        SpeedInitialOfRace(RaceType raceType, Integer minValue, Integer maxValue) {
            this.raceType = raceType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static SpeedInitialOfRace findByType(RaceType raceType) {
            for (SpeedInitialOfRace type : values()) {
                if (Objects.equals(type.raceType, raceType)) {
                    return type;
                }
            }

            return SpeedInitialOfRace.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum SpeedInitialOfJob {
        hero(JobType.hero, 5, 8),
        warrior(JobType.warrior, 3, 5),
        wizard(JobType.wizard, 4, 7),
        priest(JobType.priest, 4, 7),
        unknown(JobType.unknown, null, null);

        private final JobType jobType;
        private final Integer minValue;
        private final Integer maxValue;

        SpeedInitialOfJob(JobType jobType, Integer minValue, Integer maxValue) {
            this.jobType = jobType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static SpeedInitialOfJob findByType(JobType jobType) {
            for (SpeedInitialOfJob type : values()) {
                if (Objects.equals(type.jobType, jobType)) {
                    return type;
                }
            }

            return SpeedInitialOfJob.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }
}


