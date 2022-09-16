package com.rpg.dddRpg.domain.value;

/**
 * 攻撃力
 */
public class Power {

    int value;

    private Power(int value) {
        this.value = value;
    }


    public static Power of(int value) {
        return new Power(value);
    }

}
