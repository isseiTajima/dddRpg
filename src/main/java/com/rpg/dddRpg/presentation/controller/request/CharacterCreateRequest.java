package com.rpg.dddRpg.presentation.controller.request;

/**
 * キャラ作成リクエスト
 */
public class CharacterCreateRequest {

    private String name;

    private Integer tribeType;

    private Integer genderType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTribeType() {
        return tribeType;
    }

    public void setTribeType(Integer tribeType) {
        this.tribeType = tribeType;
    }

    public Integer getGenderType() {
        return genderType;
    }

    public void setGenderType(Integer genderType) {
        this.genderType = genderType;
    }
}
