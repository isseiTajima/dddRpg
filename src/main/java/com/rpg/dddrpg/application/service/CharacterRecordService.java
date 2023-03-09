package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.domain.model.character.CharacterFactory;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.Name;
import com.rpg.dddrpg.presentation.controller.request.CharacterCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * キャラクター登録更新に関するサービス
 */
@Service
@Transactional
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
