package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.value.Level;

public class Status {

    private final Level level;
    private final Integer attack;
    private final Integer defence;
    private final Integer speed;

    Status(Level level, Integer attack, Integer defence, Integer speed) {
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
    }

    public static Status of(Level level, Integer attack, Integer defence, Integer speed) {
        return new Status(level, attack, defence, speed);
    }

    public static Status initial() {
//        return new Status(Level.initial(),,attack, defence, speed);
        return null;
    }


    public Level getLevel() {
        return level;
    }

    public Integer getAttack() {
        return attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public Integer getSpeed() {
        return speed;
    }

    public boolean isEmpty() {
        return level.isEmpty() &&
                attack == null &&
                speed == null &&
                defence == null;

    }
}
