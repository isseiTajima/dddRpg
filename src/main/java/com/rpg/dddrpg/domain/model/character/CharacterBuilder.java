package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.model.Status;
import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Level;
import com.rpg.dddrpg.domain.value.Name;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class CharacterBuilder {


    UUID id;
    Name name;
    Level level;
    RaceType raceType;
    GenderType genderType;
    JobType jobType;
    CharacterType characterType;
    Status status;

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

    public void withStatus(Status status) {
        this.status = status;
    }

    public Character build() {

        // typeが不明の場合は作成しない
        if (this.characterType == null) {
            return null;
        }

        // idが設定されていない場合は初期化する
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }

        // レベルが設定されていない場合は初期化する
        if (this.level == null) {
            this.level = Level.initial();
        }

        // ステータスが設定されてない場合は初期化する
        if (this.status == null) {
            this.status = Status.initial(
                    this.genderType, this.raceType, this.jobType
            );
        }

        Class<?> characterClass = characterType.getTypeClass();
        try {
            // Note:今回は共通化のためEntityを抽象化したため、このようにリフレクションでのビルダーとなっているが
            // 分かりにくいのでEntityについては諦めた方が無難
            Character character = (Character) characterClass
                    .getDeclaredConstructors()[0] // 1つのコンストラクタ限定
                    .newInstance(
                            this.id, this.name, this.level, this.raceType, this.genderType, this.jobType,
                            this.characterType, this.status
                    );
            return character;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            System.out.println("クラスの作成に失敗");
            throw new RuntimeException(e);
        }
    }
}
