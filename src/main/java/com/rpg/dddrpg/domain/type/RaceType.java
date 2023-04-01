package com.rpg.dddrpg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 種族区分
 */
@AllArgsConstructor
@Getter
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


}
