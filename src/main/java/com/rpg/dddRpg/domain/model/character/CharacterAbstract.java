package com.rpg.dddRpg.domain.model.character;

import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

public abstract class CharacterAbstract implements Character {

    private final UUID id;
    private final Name name;

    private final Level level;
    private final RaceType raceType;

    private final GenderType gender;

    private final JobType job;
    private final CharacterType characterType;

    CharacterAbstract(UUID id, Name name, Level level, RaceType raceType,
                      GenderType genderType, JobType jobType, CharacterType characterType) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.raceType = raceType;
        this.gender = genderType;
        this.job = jobType;
        this.characterType = characterType;
    }

    public Name getName() {
        return name;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public GenderType getGenderType() {
        return gender;
    }

    public JobType getJobType() {
        return job;
    }

    public CharacterType getCharacterType() {
        return characterType;
    }

    public Level getLevel() {
        return level;
    }

    public UUID getId() {
        return id;
    }

    /**
     * empty判定
     *
     * @return boolean
     */
    public boolean isEmpty() {
        // idがnullの場合はempty
        return this.id == null;
    }


}
