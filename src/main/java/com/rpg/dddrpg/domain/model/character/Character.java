package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.model.Status;
import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.*;

import java.util.UUID;

public interface Character {

    Name getName();

    RaceType getRaceType();

    GenderType getGenderType();

    JobType getJobType();

    CharacterType getCharacterType();

    Level getLevel();

    UUID getId();

    Attack getAttack();

    Hp getHp();

    Defence getDefence();

    Speed getSpeed();

    Status getStatus();

    /**
     * empty判定
     *
     * @return boolean
     */
    boolean isEmpty();


}
