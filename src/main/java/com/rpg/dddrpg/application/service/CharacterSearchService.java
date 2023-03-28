package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import com.rpg.dddrpg.presentation.controller.request.CharacterSearchRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * キャラクター検索に関するサービス
 */
@Service
@Transactional
public class CharacterSearchService {

    private final CharacterRepository characterRepository;

    CharacterSearchService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    /**
     * キャラクター検索
     *
     * @param request キャラクター検索依頼
     * @return キャラクター情報
     */
    public Character execute(CharacterSearchRequest request) {
        // キャラクターの検索
        return characterRepository.findOneById(request.getId());
    }


}
