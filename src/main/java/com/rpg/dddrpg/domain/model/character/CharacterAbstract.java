package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.*;
import lombok.Getter;

import java.util.UUID;

// interface defaultでよかった
@Getter
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


    public Attack getAttack() {
        return status.getAttack();
    }

    public Hp getHp() {
        return status.getHp();
    }

    public Defence getDefence() {
        return status.getDefence();
    }

    public Speed getSpeed() {
        return status.getSpeed();
    }

    public boolean isEmpty() {
        return this.id == null;
    }

}
