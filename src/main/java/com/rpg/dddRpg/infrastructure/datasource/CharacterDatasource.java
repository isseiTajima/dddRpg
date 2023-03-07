package com.rpg.dddRpg.infrastructure.datasource;

import com.rpg.dddRpg.domain.mapper.characters.CharactersMapperEntity;
import com.rpg.dddRpg.domain.mapper.characters.CharactersMapperRepository;
import com.rpg.dddRpg.domain.model.character.Character;
import com.rpg.dddRpg.domain.model.character.CharacterFactory;
import com.rpg.dddRpg.domain.repository.CharacterRepository;
import com.rpg.dddRpg.domain.type.CharacterType;
import com.rpg.dddRpg.domain.type.GenderType;
import com.rpg.dddRpg.domain.type.JobType;
import com.rpg.dddRpg.domain.type.RaceType;
import com.rpg.dddRpg.domain.value.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CharacterDatasource implements CharacterRepository {

    @Autowired
    private CharactersMapperRepository charactersMapperRepository;

    @Override
    public Character findOneById(UUID id) {

        // キャラクター情報を取得する
        CharactersMapperEntity entity = charactersMapperRepository.findById(id.toString());

        var factory = new CharacterFactory();

        // 存在しない場合は空を返す
        if (entity == null) {
            return factory.build();
        }

        // Entityからキャラクターを作成する
        factory.withId(UUID.fromString(entity.getId()));
        factory.withName(Name.of(entity.getName()));
        factory.withJobType(JobType.findByCode(entity.getJobType()));
        factory.withGenderType(GenderType.findByCode(entity.getGenderType()));
        factory.withRaceType(RaceType.findByCode(entity.getRaceType()));
        factory.withCharacterType(CharacterType.findByCode(entity.getCharacterType()));


//        return Character.CharacterFactory.createCharacter(
//                UUID.fromString(entity.getId()),
//                Name.of(entity.getName()),
//                JobType.findByCode(entity.getJobType()),
//                GenderType.findByCode(entity.getGenderType()),
//                RaceType.findByCode(entity.getGenderType())
//        );
        // 作成は一旦playable固定
        return factory.build();
    }

    @Override
    public void save(Character character) {

        // 存在チェック
        Character duplicateCharacter = findOneById(character.getId());

        // 存在しない場合はインサート
        if (duplicateCharacter == null) {
            // キャラクターテーブルにインサート
            insertCharacter(character);
            // キャラクターステータステーブルにインサート
        }

        // 存在する場合はアプデート
        updateCharacter(character);
    }

    /**
     * キャラクターテーブルにインサート
     *
     * @param character 　登録するキャラクター
     */
    void insertCharacter(Character character){
        // キャラクターテーブルにインサート
        charactersMapperRepository.insert(createMapperEntityFrom(character));
    }

    /**
     * キャラクターテーブルにアップデート
     *
     * @param character 　更新するキャラクター
     */
    void updateCharacter(Character character){
        // キャラクターテーブルにインサート
        charactersMapperRepository.update(createMapperEntityFrom(character));
    }

    /**
     * MapperEntityを作成する
     * @param character キャラクター
     * @return MapperEntity
     */
    CharactersMapperEntity createMapperEntityFrom(Character character){
        CharactersMapperEntity entity = new CharactersMapperEntity();
        entity.setId(character.getId().toString());
        entity.setName(character.getName().getValue());
        entity.setGenderType(character.getGenderType().getCode());
        entity.setRaceType(character.getRaceType().getCode());
        entity.setJobType(character.getJobType().getCode());
        entity.setCharacterType(character.getCharacterType().getCode());
        return entity;
    }

}
