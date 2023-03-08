package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.*;

public class Status {

    private final Level level;
    private final Hp hp;
    private final Attack attack;
    private final Defence defence;
    private final Speed speed;

    Status(Level level, Hp hp, Attack attack,
           Defence defence, Speed speed) {
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static Status of(Level level, Hp hp, Attack attack,
                            Defence defence, Speed speed) {
        return new Status(level, hp, attack, defence, speed);
    }

    public static Status initial(GenderType genderType, RaceType raceType, JobType jobType) {
        return new Status(Level.initial(),
                Hp.initial(genderType, raceType, jobType),
                Attack.initial(genderType, raceType, jobType),
                Defence.initial(genderType, raceType, jobType),
                Speed.initial(genderType, raceType, jobType));
    }


    public Level getLevel() {
        return level;
    }


    public boolean isEmpty() {
        return level.isEmpty() &&
                attack.isEmpty() &&
                speed.isEmpty() &&
                defence.isEmpty();

    }

    public Hp getHp() {
        return hp;
    }

    public Attack getAttack() {
        return attack;
    }

    public Defence getDefence() {
        return defence;
    }

    public Speed getSpeed() {
        return speed;
    }
}
