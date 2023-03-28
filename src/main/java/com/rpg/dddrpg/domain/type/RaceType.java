package com.rpg.dddrpg.domain.type;

/**
 * 種族区分
 */
public enum RaceType {

    human("人間") {

    },
    elf("エルフ") {

    },
    ogre("オーガ") {

    },
    unknown("不明") {

    };
    private final String name;

    RaceType(String name) {
        this.name = name;
    }

    public static RaceType findByName(String name) {
        return RaceType.valueOf(name);
    }

    public boolean isHuman() {
        return this == RaceType.human;
    }

    public boolean isElf() {
        return this == RaceType.elf;
    }

    public boolean isOgre() {
        return this == RaceType.ogre;
    }

    public String getName() {
        return name;
    }

}
