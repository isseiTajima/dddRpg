package com.rpg.dddRpg.domain.model;

import com.rpg.dddRpg.domain.type.GenderClassification;
import com.rpg.dddRpg.domain.type.TribeClassification;
import com.rpg.dddRpg.domain.value.Level;
import com.rpg.dddRpg.domain.value.Name;

import java.util.UUID;

public class Character {

    private final UUID id;
    private final Name name;

    private final Level level;
    private final TribeClassification tribe;

    private final GenderClassification gender;

    private final Equipment equipment;

    private final Job job;

    Character(UUID id, Name name, Level level, TribeClassification tribe,
              GenderClassification gender, Equipment equipment, Job job) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.tribe = tribe;
        this.gender = gender;
        this.equipment = equipment;
        this.job = job;
    }

    public Name getName() {
        return name;
    }

    public TribeClassification getTribe() {
        return tribe;
    }

    public GenderClassification getGender() {
        return gender;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Job getBusiness() {
        return job;
    }

    public Level getLevel() {
        return level;
    }

    public UUID getId() {
        return id;
    }


    /**
     * キャラクター生成
     */
    public static class CharacterFactory {
        public static Character createCharacter(Name name, TribeClassification tribe, GenderClassification gender) {
            return new Character(
                    UUID.randomUUID(),
                    name,
                    Level.initial(),
                    tribe,
                    gender,
                    Equipment.initial(),
                    Job.initial());

        }
    }
}
