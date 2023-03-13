package com.rpg.dddrpg.presentation.controller.request;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * キャラ作成リクエスト
 */
@Getter
@Setter
public class CharacterCreateRequest {

    private UUID id;
    private String name;
    private String characterTypeName;
    private String genderTypeName;
    private String raceTypeName;
    private String jobTypeName;
}
