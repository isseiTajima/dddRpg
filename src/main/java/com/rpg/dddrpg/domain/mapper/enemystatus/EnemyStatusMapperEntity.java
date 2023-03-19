package com.rpg.dddrpg.domain.mapper.enemystatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnemyStatusMapperEntity {
    private String id;
    private String enemyId;
    private Integer level;
    private Integer hp;
    private Integer attack;
    private Integer defence;
    private Integer speed;

}
