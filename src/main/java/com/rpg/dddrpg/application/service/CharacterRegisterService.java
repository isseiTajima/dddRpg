package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.application.service.request.CharacterRegisterServiceRequest;
import com.rpg.dddrpg.domain.model.character.CharacterBuilder;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * キャラクター登録更新に関するサービス
 */
@Service
@Transactional
public class CharacterRegisterService {

    @Autowired
    private final CharacterRepository characterRepository;

    CharacterRegisterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * キャラクター作成(登録)
     *
     * @param request キャラクター作成依頼
     * @return キャラクター
     */
    public void create(CharacterRegisterServiceRequest request) {


        // キャラクターの生成
        CharacterBuilder factory = new CharacterBuilder();
        factory.withId(request.getId());
        factory.withName(request.getName());
        factory.withJobType(request.getJobType());
        factory.withGenderType(request.getGenderType());
        factory.withRaceType(request.getRaceType());
        factory.withCharacterType(request.getCharacterType());

        // キャラクターの保存
        characterRepository.save(factory.build());
    }

}
