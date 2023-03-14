package com.rpg.dddrpg.domain.model.battle;

import com.rpg.dddrpg.domain.type.ActionType;
import com.rpg.dddrpg.domain.value.Hp;
import com.rpg.dddrpg.domain.value.TurnCount;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class BattleDetailHistory {

    private UUID id;
    private UUID battleHistoryId;
    private TurnCount turnCount;
    private UUID characterId;
    private ActionType actionType;
    private Hp hp;

    private UUID enemyCharacterId;
    private ActionType enemyActionType;
    private Hp enemyHp;

}
