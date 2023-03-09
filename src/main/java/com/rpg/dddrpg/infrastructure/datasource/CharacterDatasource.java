package com.rpg.dddrpg.infrastructure.datasource;

import com.rpg.dddrpg.domain.mapper.characters.CharactersMapperEntity;
import com.rpg.dddrpg.domain.mapper.characters.CharactersMapperRepository;
import com.rpg.dddrpg.domain.mapper.characterstatus.CharacterStatusMapperEntity;
import com.rpg.dddrpg.domain.mapper.characterstatus.CharacterStatusMapperRepository;
import com.rpg.dddrpg.domain.model.Status;
import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.model.character.CharacterFactory;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import com.rpg.dddrpg.domain.type.CharacterType;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CharacterDatasource implements CharacterRepository {

    @Autowired
    private CharactersMapperRepository charactersMapperRepository;
    @Autowired
    private CharacterStatusMapperRepository characterStatusMapperRepository;

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
        // ステータスを取得して設定
        factory.withStatus(createStatus(id));

        return factory.build();
    }

    /**
     * キャラクターIDからステータスを取得して生成する
     *
     * @param id キャラクターID
     * @return　ステータス
     */
    Status createStatus(UUID id) {

        // キャラクタIDからステータスEntityを取得
        var entity = characterStatusMapperRepository.findByCharacterId(id.toString());

        return Status.of(UUID.fromString(entity.getId()),
                Level.of(entity.getLevel()),
                Hp.of(entity.getHp()),
                Attack.of(entity.getAttack()),
                Defence.of(entity.getDefence()),
                Speed.of(entity.getSpeed()));
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
            insertCharacterStatus(character);
        } else {
            // 存在する場合はアプデート
            updateCharacter(character);
            // キャラクターステータスもアップデート
            updateCharacterStatus(character);
        }
    }

    /**
     * キャラクターテーブルにインサート
     *
     * @param character 　登録するキャラクター
     */
    void insertCharacter(Character character) {
        // キャラクターテーブルにインサート
        charactersMapperRepository.insert(createMapperEntityFrom(character));
    }

    /**
     * キャラクターステータステーブルにインサート
     *
     * @param character 　登録するキャラクター
     */
    void insertCharacterStatus(Character character) {
        // キャラクターテーブルにインサート
        characterStatusMapperRepository.insert(createStatusMapperEntityFrom(character.getId(),
                character.getStatus()));
    }

    /**
     * キャラクターテーブルにアップデート
     *
     * @param character 　更新するキャラクター
     */
    void updateCharacter(Character character) {
        // キャラクターテーブルにインサート
        charactersMapperRepository.update(createMapperEntityFrom(character));
    }

    /**
     * キャラクターステータステーブルをアップデート
     *
     * @param character 　登録するキャラクター
     */
    void updateCharacterStatus(Character character) {
        // キャラクターテーブルにインサート
        characterStatusMapperRepository.update(createStatusMapperEntityFrom(character.getId(),
                character.getStatus()));
    }

    /**
     * MapperEntityを作成する
     *
     * @param character キャラクター
     * @return MapperEntity
     */
    CharactersMapperEntity createMapperEntityFrom(Character character) {
        CharactersMapperEntity entity = new CharactersMapperEntity();
        entity.setId(character.getId().toString());
        entity.setName(character.getName().getValue());
        entity.setGenderType(character.getGenderType().getCode());
        entity.setRaceType(character.getRaceType().getCode());
        entity.setJobType(character.getJobType().getCode());
        entity.setCharacterType(character.getCharacterType().getCode());
        return entity;
    }


    /**
     * MapperEntityを作成する
     *
     * @param characterId キャラクターId
     * @param status      キャラクターステータス
     * @return MapperEntity
     */
    CharacterStatusMapperEntity createStatusMapperEntityFrom(UUID characterId,
                                                             Status status) {
        var entity = new CharacterStatusMapperEntity();
        entity.setId(status.getId().toString());
        entity.setCharacterId(characterId.toString());
        entity.setLevel(status.getLevel().getValue());
        entity.setHp(status.getHp().getValue());
        entity.setAttack(status.getAttack().getValue());
        entity.setDefence(status.getDefence().getValue());
        entity.setSpeed(status.getSpeed().getValue());
        return entity;
    }

}
