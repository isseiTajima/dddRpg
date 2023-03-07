package com.rpg.dddRpg.domain.model.character;

import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

public class PlayableCharacter extends CharacterAbstract {

    public PlayableCharacter(UUID id, Name name, Level level, RaceType raceType,
                             GenderType gender, JobType job, CharacterType characterType) {
        super(id, name, level, raceType, gender, job, characterType);
    }


}
