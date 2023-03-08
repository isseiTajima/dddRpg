package com.rpg.dddRpg.domain.model.character;

import com.rpg.dddRpg.domain.model.Status;
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

    private final GenderType genderType;

    private final JobType jobType;
    private final CharacterType characterType;
    private final Status status;

    CharacterAbstract(UUID id, Name name, Level level, RaceType raceType,
                      GenderType genderType, JobType jobType, CharacterType characterType,
                      Status status) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.raceType = raceType;
        this.genderType = genderType;
        this.jobType = jobType;
        this.characterType = characterType;
        this.status = status;
    }

    public Name getName() {
        return name;
    }

    public RaceType getRaceType() {
        return raceType;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public JobType getJobType() {
        return jobType;
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


    @Override
    public Status getStatus() {
        return status;
    }
}
