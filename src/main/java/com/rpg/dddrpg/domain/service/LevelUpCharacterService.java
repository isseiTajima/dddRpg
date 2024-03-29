package com.rpg.dddrpg.domain.service;

import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * キャラクターレベルアップ操作
 */
@Service
public class LevelUpCharacterService {

    @Autowired
    private final CharacterRepository characterRepository;

    public LevelUpCharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public Character levelUp(UUID id) {

        Character character = characterRepository.findOneById(id);

        // レベルアップ
//        Character levelUpedCharacter = character.getLevel().up();

        characterRepository.save(character);

        return character;
    }

}
