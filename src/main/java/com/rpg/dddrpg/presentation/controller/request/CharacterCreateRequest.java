package com.rpg.dddrpg.presentation.controller.request;

import java.util.UUID;

/**
 * キャラ作成リクエスト
 */
public class CharacterCreateRequest {

    private UUID id;
    private String name;
    private String characterTypeName;
    private String genderTypeName;
    private String raceTypeName;
    private String jobTypeName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenderTypeName() {
        return genderTypeName;
    }

    public void setGenderTypeName(String genderTypeName) {
        this.genderTypeName = genderTypeName;
    }


    public String getRaceTypeName() {
        return raceTypeName;
    }

    public void setRaceTypeName(String raceTypeName) {
        this.raceTypeName = raceTypeName;
    }

    public String getJobTypeName() {
        return jobTypeName;
    }

    public void setJobTypeName(String jobTypeName) {
        this.jobTypeName = jobTypeName;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCharacterTypeName() {
        return characterTypeName;
    }

    public void setCharacterTypeName(String characterTypeName) {
        this.characterTypeName = characterTypeName;
    }
}
