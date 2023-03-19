package com.rpg.dddrpg.domain.model.enemy;

import com.rpg.dddrpg.domain.value.*;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class EnemyStatus {

    private UUID id;
    private UUID enemyId;
    private Level level;
    private Hp hp;
    private Attack attack;
    private Defence defence;
    private Speed speed;

    public boolean isEmpty() {
        return getId() == null;

    }
}
