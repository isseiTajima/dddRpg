package com.rpg.dddRpg.application.service;

import com.rpg.dddRpg.domain.model.character.CharacterFactory;
import com.rpg.dddRpg.domain.repository.CharacterRepository;
import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Name;
import com.rpg.dddRpg.presentation.controller.request.CharacterCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * キャラクター登録更新に関するサービス
 */
@Service
public class CharacterRecordService {

    @Autowired
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
    public void create(CharacterCreateRequest request) {


        // キャラクターの生成
        CharacterFactory factory = new CharacterFactory();
        factory.withId(request.getId());
        factory.withName(Name.of(request.getName()));
        factory.withJobType(JobType.findByName(request.getJobTypeName()));
        factory.withGenderType(GenderType.findByName(request.getGenderTypeName()));
        factory.withRaceType(RaceType.findByName(request.getRaceTypeName()));
        factory.withCharacterType(CharacterType.findByName(request.getCharacterTypeName()));

        // キャラクターの保存
        characterRepository.save(factory.build());
    }

}
