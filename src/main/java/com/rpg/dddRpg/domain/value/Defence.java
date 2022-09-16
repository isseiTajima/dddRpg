package com.rpg.dddRpg.domain.value;

/**
 * 防御力
 */
public class Defence {

    int value;

    private Defence(int value) {
        this.value = value;
    }


    public static Defence of(int value) {
        return new Defence(value);
    }

}
