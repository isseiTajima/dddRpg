package com.rpg.dddrpg.domain.model.battle;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class BattleDetailsHistory {

    private List<BattleDetailHistory> list;


}
