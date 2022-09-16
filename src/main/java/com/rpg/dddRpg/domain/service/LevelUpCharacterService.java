package com.rpg.dddRpg.domain.service;

import com.rpg.dddRpg.domain.model.Character;
import com.rpg.dddRpg.domain.repository.CharacterRepository;

import java.util.UUID;

/**
 * キャラクターレベルアップ操作
 */
public class LevelUpCharacterService {

    private final CharacterRepository characterRepository;

    public LevelUpCharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character levelUp(UUID id) {

        Character character = characterRepository.findOneById(id);

        // レベルアップ
        character.getLevel().up();

        return characterRepository.save(character);
    }

}
