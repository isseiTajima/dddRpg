package com.rpg.dddrpg.domain.model.battle;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class BattleHistory {

    private UUID id;
    private UUID winnerCharacterId;
    private BattleDetailsHistory battleDetailsHistory;


}
