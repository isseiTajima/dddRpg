package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Level;
import com.rpg.dddrpg.domain.value.Name;

import java.util.UUID;

public class PlayableCharacter extends CharacterAbstract {

    public PlayableCharacter(UUID id, Name name, Level level, RaceType raceType,
                             GenderType gender, JobType job, CharacterType characterType,
                             Status status) {
        super(id, name, level, raceType, gender, job, characterType, status);
    }


}
