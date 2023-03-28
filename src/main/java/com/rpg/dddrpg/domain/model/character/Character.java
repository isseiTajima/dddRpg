package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Level;
import com.rpg.dddrpg.domain.value.Name;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Builder(toBuilder = true)
@Value
public class Character {

    private final UUID id;
    private final Name name;

    private final Level level;
    private final RaceType raceType;

    private final GenderType genderType;

    private final JobType jobType;
    private final CharacterType characterType;
    private final Status status;

    public boolean isEmpty() {
        return this.id == null;
    }

}
