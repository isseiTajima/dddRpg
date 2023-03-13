package com.rpg.dddrpg.presentation.controller.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * キャラ検索リクエスト
 */
@Setter
@Getter
public class CharacterSearchResponse {

    private UUID id;
    private String name;
    private String characterTypeName;
    private String genderTypeName;
    private String raceTypeName;
    private String jobTypeName;
    private Integer level;
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer speed;

}
