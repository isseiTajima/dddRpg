package com.rpg.dddRpg.domain.value;

/**
 * レベル
 */
public class Level {

    Integer value;

    private Level(Integer value) {
        this.value = value;
    }


    public static Level of(Integer value) {
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
    public Level up() {
        return Level.of(value+1);
    }

    public static Level empty() {
        return new Level(null);
    }

}
