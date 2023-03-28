package com.rpg.dddrpg.domain.model.enemy;

import com.rpg.dddrpg.domain.value.Name;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
public class Enemy {

    private final UUID id;
    private final Name name;
    private final EnemyStatus status;

    public boolean isEmpty() {
        return this.id == null;

    }

}
