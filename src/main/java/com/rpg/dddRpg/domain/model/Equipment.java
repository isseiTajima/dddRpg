package com.rpg.dddRpg.domain.model;

/**
 * 装備
 */
public class Equipment {

    private final Weapon weapon;
    private final Armor armor;

    Equipment(Weapon weapon, Armor armor) {
        this.weapon = weapon;
        this.armor = armor;
    }

    /**
     * 初期装備で生成
     */
    public static Equipment initial() {
        return new Equipment(new Weapon(), new Armor());
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }
}
