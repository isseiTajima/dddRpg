package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.application.service.request.CharacterRegisterServiceRequest;
import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.model.character.Status;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

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
    public void execute(CharacterRegisterServiceRequest request) {


        // キャラクターの生成
        UUID id = UUID.randomUUID();
        if (request.getId() != null) {
            id = request.getId();
        }
        var factory = Character.builder()
                .id(id)
                .name(request.getName())
                .jobType(request.getJobType())
                .genderType(request.getGenderType())
                .raceType(request.getRaceType())
                .status(Status.initial(request.getGenderType(),
                        request.getRaceType(), request.getJobType()));

        // キャラクターの保存
        characterRepository.save(factory.build());
    }

}
