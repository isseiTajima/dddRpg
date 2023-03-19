package com.rpg.dddrpg.domain.value;

import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import lombok.Value;

import java.util.Objects;
import java.util.Random;

/**
 * 体力みたいな
 */
@Value(staticConstructor = "of")
public class Hp {
    private Integer value;

    public static Hp initial(GenderType genderType, RaceType raceType,
                             JobType jobType) {
        // 初期値
        Integer hpValue = 1;
        // 性別による加算値を取得
        Integer addOfGenderValue = calcAddValueOfGender(genderType);
        // 種族による加算値を取得
        Integer addOfRaceValue = calcAddValueOfRace(raceType);
        // 職業による加算値を取得
        Integer addOfJobValue = calcAddValueOfJob(jobType);

        // 加算値の合計を初期値とする
        return new Hp(hpValue + addOfGenderValue + addOfRaceValue + addOfJobValue);
    }

    public static Hp randomInitial() {
        var random = new Random();
        return Hp.of(random.nextInt(30,
                100));
    }

    static Integer calcAddValueOfRace(RaceType raceType) {
        // 種族の初期値を取得
        var hpInitialValue = HpInitialOfRace.findByType(raceType);
        Integer diffValue = calcRandomDiffValue(hpInitialValue.getMinValue(),
                hpInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return hpInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfGender(GenderType genderType) {

        // 性別の初期値を取得
        var hpInitialValue = HpInitialOfGender.findByType(genderType);
        Integer diffValue = calcRandomDiffValue(hpInitialValue.getMinValue(),
                hpInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return hpInitialValue.getMinValue() + diffValue;
    }

    static Integer calcAddValueOfJob(JobType jobType) {

        // 性別の初期値を取得
        var hpInitialValue = HpInitialOfJob.findByType(jobType);
        Integer diffValue = calcRandomDiffValue(hpInitialValue.getMinValue(),
                hpInitialValue.getMaxValue());

        // 乱数と初期値から加算値を返却
        return hpInitialValue.getMinValue() + diffValue;
    }

    static Integer calcRandomDiffValue(Integer minValue, Integer maxValue) {

        // 乱数を生成
        Random random = new Random();
        Integer randomValue = random.nextInt(minValue,
                maxValue);

        // 範囲内の乱数と最小値の差を求める
        return randomValue - minValue;

    }
    public boolean isEmpty() {
        return this.value == null;
    }

    enum HpInitialOfGender {
        man(GenderType.man, 10, 15),
        female(GenderType.female, 8, 13),
        unknown(GenderType.unknown, null, null);

        private final GenderType genderType;
        private final Integer minValue;
        private final Integer maxValue;

        HpInitialOfGender(GenderType genderType, Integer minValue, Integer maxValue) {
            this.genderType = genderType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static HpInitialOfGender findByType(GenderType genderType) {
            for (HpInitialOfGender type : values()) {
                if (Objects.equals(type.genderType, genderType)) {
                    return type;
                }
            }

            return HpInitialOfGender.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum HpInitialOfRace {
        human(RaceType.human, 10, 15),
        elf(RaceType.elf, 8, 13),
        ogre(RaceType.ogre, 15, 20),
        unknown(RaceType.unknown, null, null);

        private final RaceType raceType;
        private final Integer minValue;
        private final Integer maxValue;

        HpInitialOfRace(RaceType raceType, Integer minValue, Integer maxValue) {
            this.raceType = raceType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static HpInitialOfRace findByType(RaceType raceType) {
            for (HpInitialOfRace type : values()) {
                if (Objects.equals(type.raceType, raceType)) {
                    return type;
                }
            }

            return HpInitialOfRace.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }

    enum HpInitialOfJob {
        hero(JobType.hero, 10, 15),
        warrior(JobType.warrior, 15, 20),
        wizard(JobType.wizard, 5, 10),
        priest(JobType.priest, 5, 10),
        unknown(JobType.unknown, null, null);

        private final JobType jobType;
        private final Integer minValue;
        private final Integer maxValue;

        HpInitialOfJob(JobType jobType, Integer minValue, Integer maxValue) {
            this.jobType = jobType;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        static HpInitialOfJob findByType(JobType jobType) {
            for (HpInitialOfJob type : values()) {
                if (Objects.equals(type.jobType, jobType)) {
                    return type;
                }
            }

            return HpInitialOfJob.unknown;
        }


        public Integer getMinValue() {
            return minValue;
        }

        public Integer getMaxValue() {
            return maxValue;
        }
    }
}


