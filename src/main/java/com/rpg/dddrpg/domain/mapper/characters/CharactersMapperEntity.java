package com.rpg.dddrpg.domain.mapper.characters;

public class CharactersMapperEntity {

    private String id;
    private String name;
    private Integer jobType;
    private Integer genderType;
    private Integer raceType;
    private Integer characterType;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }

    public Integer getGenderType() {
        return genderType;
    }

    public void setGenderType(Integer genderType) {
        this.genderType = genderType;
    }

    public Integer getRaceType() {
        return raceType;
    }

    public void setRaceType(Integer raceType) {
        this.raceType = raceType;
    }

    public Integer getCharacterType() {
        return characterType;
    }

    public void setCharacterType(Integer characterType) {
        this.characterType = characterType;
    }
}