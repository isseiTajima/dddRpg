package com.rpg.dddRpg.presentation.controller.request;

import java.util.UUID;

/**
 * キャラ作成リクエスト
 */
public class CharacterCreateRequest {

    private String name;

    private UUID jobId;

    private Integer genderType;
    private Integer raceType;
    private Integer jobType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGenderType() {
        return genderType;
    }

    public void setGenderType(Integer genderType) {
        this.genderType = genderType;
    }

    public UUID getJobId() {
        return jobId;
    }

    public void setJobId(UUID jobId) {
        this.jobId = jobId;
    }

    public Integer getRaceType() {
        return raceType;
    }

    public void setRaceType(Integer raceType) {
        this.raceType = raceType;
    }

    public Integer getJobType() {
        return jobType;
    }

    public void setJobType(Integer jobType) {
        this.jobType = jobType;
    }
}
