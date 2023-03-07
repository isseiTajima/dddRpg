package com.rpg.dddRpg.domain.value;

/**
 * 名称
 */
public class Name {

    String value;

    private Name(String value) {
        this.value = value;
    }


    public static Name of(String value) {
        return new Name(value);
    }

    public static Name empty() {
        return new Name(null);
    }

    public String getValue() {
        return this.value;
    }


}
