package com.rpg.dddRpg.domain.value;

/**
 * 体力みたいな
 */
public class Hp {

    int value;

    private Hp(int value) {
        this.value = value;
    }


    public static Hp of(int value) {
        return new Hp(value);
    }

}
