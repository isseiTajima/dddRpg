package com.rpg.dddRpg.domain.value;

/**
 * レベル
 */
public class Level {

    int value;

    private Level(int value) {
        this.value = value;
    }


    public static Level of(int value) {
        return new Level(value);
    }

    /**
     * 初期レベルで生成
     *
     * @return 初期レベル
     */
    public static Level initial() {
        return new Level(1);
    }

    /**
     * レベルアップ
     */
    public void up() {
        value++;
    }

}
