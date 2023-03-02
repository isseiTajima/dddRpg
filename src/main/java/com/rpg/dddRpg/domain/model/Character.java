package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

public class Character {

    private final UUID id;
    private final Name name;

    private final Level level;
    private final RaceType tribe;

    private final GenderType gender;

    private final JobType job;

    Character(UUID id, Name name, Level level, RaceType tribe,
              GenderType gender, JobType job) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.tribe = tribe;
        this.gender = gender;
        this.job = job;
    }

    public Name getName() {
        return name;
    }

    public RaceType getRaceType() {
        return tribe;
    }

    public GenderType getGenderType() {
        return gender;
    }

    public JobType getJobType() {
        return job;
    }

    public Level getLevel() {
        return level;
    }

    public UUID getId() {
        return id;
    }

    /**
     * empty判定
     * @return boolean
     */
    public boolean isEmpty(){
        // idがnullの場合はempty
        return this.id == null;
    }

    /**
     * キャラクター生成
     */
    public static class CharacterFactory {
        public static Character createCharacter(Name name, JobType jobType,
                                                GenderType genderType, RaceType raceType) {
            return new Character(
                    UUID.randomUUID(),
                    name,
                    Level.initial(),
                    raceType,
                    genderType,
                    jobType);

        }
        public static Character createEmptyCharacter() {
            return new Character(
                    null,
                    null,
                    Level.empty(),
                    RaceType.unknown,
                    GenderType.unknown,
                    JobType.unknown);

        }
    }

}
