package com.rpg.dddrpg.domain.model.character;

import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.*;

import java.util.UUID;

public class Status {

    private final UUID id;
    private final Level level;
    private final Hp hp;
    private final Attack attack;
    private final Defence defence;
    private final Speed speed;

    Status(UUID id, Level level, Hp hp, Attack attack,
           Defence defence, Speed speed) {
        this.id = id;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static Status of(UUID id, Level level, Hp hp, Attack attack,
                            Defence defence, Speed speed) {
        return new Status(id, level, hp, attack, defence, speed);
    }

    public static Status initial(GenderType genderType, RaceType raceType, JobType jobType) {
        return new Status(UUID.randomUUID(),
                Level.initial(),
                Hp.initial(genderType, raceType, jobType),
                Attack.initial(genderType, raceType, jobType),
                Defence.initial(genderType, raceType, jobType),
                Speed.initial(genderType, raceType, jobType));
    }


    public Level getLevel() {
        return level;
    }


    public boolean isEmpty() {
        return getId() == null;

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

    public UUID getId() {
        return id;
    }
}
