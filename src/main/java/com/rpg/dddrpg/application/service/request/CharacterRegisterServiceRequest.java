package com.rpg.dddrpg.application.service.request;

import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Name;
import lombok.Getter;

import java.util.UUID;

/**
 * キャラ作成リクエスト
 */
@Getter
public class CharacterRegisterServiceRequest {

    private UUID id;
    private Name name;
    private CharacterType characterType;
    private GenderType genderType;
    private RaceType raceType;
    private JobType jobType;

    CharacterRegisterServiceRequest(UUID id, Name name,
                                    CharacterType characterType, GenderType genderType,
                                    RaceType raceType, JobType jobType) {
        this.id = id;
        this.name = name;
        this.characterType = characterType;
        this.genderType = genderType;
        this.raceType = raceType;
        this.jobType = jobType;
    }

    public static CharacterRegisterServiceRequest of(UUID id, Name name,
                                                     CharacterType characterType, GenderType genderType,
                                                     RaceType raceType, JobType jobType) {
        return new CharacterRegisterServiceRequest(id, name, characterType,
                genderType, raceType, jobType);
    }

}
