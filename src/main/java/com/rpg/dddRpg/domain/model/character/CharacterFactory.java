package com.rpg.dddRpg.domain.model.character;

import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class CharacterFactory {


    UUID id;
    Name name;
    Level level;
    RaceType raceType;
    GenderType genderType;
    JobType jobType;
    CharacterType characterType;

//    public static Character createCharacter(UUID id, Name name, JobType jobType,
//                                            GenderType genderType, RaceType raceType) {
//        UUID createId = id;
//        if (id == null) {
//            // idが設定されてない場合は生成する
//            createId = UUID.randomUUID();
//        }
//        return new CharacterAbstract(
//                createId,
//                name,
//                Level.initial(),
//                raceType,
//                genderType,
//                jobType);
//
//    }
//
//    public static CharacterAbstract createEmptyCharacter() {
//        return new CharacterAbstract(
//                null,
//                null,
//                Level.empty(),
//                RaceType.unknown,
//                GenderType.unknown,
//                JobType.unknown);
//
//    }

    public void withId(UUID id) {
        this.id = id;
    }

    public void withName(Name name) {
        this.name = name;
    }

    public void withLevel(Level level) {
        this.level = level;
    }

    public void withRaceType(RaceType raceType) {
        this.raceType = raceType;
    }

    public void withGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public void withJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public void withCharacterType(CharacterType characterType) {
        this.characterType = characterType;
    }

    public Character build() {

        // typeが不明の場合は作成しない
        if (characterType.isUnknown()) {
            return null;
        }

        // レベルが設定されていない場合は初期化する
        if (this.level == null) {
            this.level = Level.initial();
        }

        Class<?> characterClass = characterType.getTypeClass();
        try {
            // Note:リフレクションでインスタンス作成、もっといい方法はないか・・・
            Character character = (Character) characterClass
                    .getDeclaredConstructors()[0]
                    .newInstance(
                            this.id, this.name, this.level, this.raceType, this.genderType, this.jobType,
                            this.characterType
                    );
            return character;
        } catch (InvocationTargetException e) {
            System.out.println("クラスの作成に失敗");
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
