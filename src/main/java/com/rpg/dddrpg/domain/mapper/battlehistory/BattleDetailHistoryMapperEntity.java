package com.rpg.dddrpg.domain.mapper.battlehistory;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BattleDetailHistoryMapperEntity {

    private String id;
    private String battleHistoryId;
    private UUID characterId;
    private String actionType;
    private Integer hp;
    private UUID enemyCharacterId;
    private String enemyActionType;
    private Integer enemyHp;
}
