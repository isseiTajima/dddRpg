package com.rpg.dddRpg.domain.model.character;

import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

public interface Character {

    Name getName();

    RaceType getRaceType();

    GenderType getGenderType();

    JobType getJobType();

    CharacterType getCharacterType();

    Level getLevel();

    UUID getId();

    /**
     * empty判定
     *
     * @return boolean
     */
    boolean isEmpty();

}
