package com.rpg.dddRpg.application.service;

import com.rpg.dddRpg.domain.model.Character;
import com.rpg.dddRpg.domain.repository.CharacterRepository;
import com.rpg.dddRpg.domain.type.GenderClassification;
import com.rpg.dddRpg.domain.type.TribeClassification;
import com.rpg.dddRpg.domain.value.Name;
import com.rpg.dddRpg.presentation.controller.request.CharacterCreateRequest;

/**
 * キャラクター登録更新に関するサービス
 */
public class CharacterRecordService {

    private final CharacterRepository characterRepository;

    CharacterRecordService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * キャラクター作成(登録)
     *
     * @param request キャラクター作成依頼
     * @return キャラクター
     */
    public Character create(CharacterCreateRequest request) {

        // キャラクターの生成
        Character character = Character.CharacterFactory.createCharacter(Name.of(request.getName())
                , TribeClassification.findByCode(request.getTribeType())
                , GenderClassification.findByCode(request.getGenderType()));

        // キャラクターの保存
        return characterRepository.save(character);
    }

}
