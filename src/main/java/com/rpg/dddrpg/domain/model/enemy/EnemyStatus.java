package com.rpg.dddrpg.domain.model.enemy;

import com.rpg.dddrpg.domain.value.*;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder(toBuilder = true)
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

    /**
     * 攻撃後のHPを返却する
     *
     * @param attack 攻撃
     * @return　攻撃後のHP
     */
    public Hp attackedHp(Attack attack) {
        // HP - (Defence/2 - attack)
        return Hp.of(this.hp.getValue() - (this.defence.getValue() / 2)
                - attack.getValue());
    }

    /**
     * 防御追加
     *
     * @param attack
     * @return
     */
    public Hp attackedDefenceHp(Attack attack) {
        // HP - Defence - attack
        return Hp.of(this.hp.getValue() - this.defence.getValue()
                - attack.getValue());
    }

}
