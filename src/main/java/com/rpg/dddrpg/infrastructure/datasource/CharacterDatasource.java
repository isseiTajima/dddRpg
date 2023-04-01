package com.rpg.dddrpg.infrastructure.datasource;

import com.rpg.dddrpg.domain.mapper.characters.CharactersMapperEntity;
import com.rpg.dddrpg.domain.mapper.characters.CharactersMapperRepository;
import com.rpg.dddrpg.domain.mapper.characterstatus.CharacterStatusMapperEntity;
import com.rpg.dddrpg.domain.mapper.characterstatus.CharacterStatusMapperRepository;
import com.rpg.dddrpg.domain.model.character.Character;
import com.rpg.dddrpg.domain.model.character.Status;
import com.rpg.dddrpg.domain.repository.CharacterRepository;
import com.rpg.dddrpg.domain.type.GenderType;
import com.rpg.dddrpg.domain.type.JobType;
import com.rpg.dddrpg.domain.type.RaceType;
import com.rpg.dddrpg.domain.value.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CharacterDatasource implements CharacterRepository {

    private CharactersMapperRepository charactersMapperRepository;
    private CharacterStatusMapperRepository characterStatusMapperRepository;

    CharacterDatasource(CharactersMapperRepository charactersMapperRepository,
                        CharacterStatusMapperRepository characterStatusMapperRepository) {
        this.charactersMapperRepository = charactersMapperRepository;
        this.characterStatusMapperRepository = characterStatusMapperRepository;
    }

    @Override
    public Character findOneById(UUID id) {

        // キャラクター情報を取得する
        CharactersMapperEntity entity = charactersMapperRepository.findById(id.toString());

        // 存在しない場合は空を返す
        if (entity == null) {
            return Character.builder().build();
        }

        // Entityからキャラクターを作成する
        return Character.builder()
                .id(UUID.fromString(entity.getId()))
                .name(Name.of(entity.getName()))
                .jobType(JobType.findByName(entity.getJobType()))
                .genderType(GenderType.findByName(entity.getGenderType()))
                .raceType(RaceType.findByName(entity.getRaceType()))
                // ステータスを取得して設定
                .status(createStatus(id))
                .build();
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
        if (duplicateCharacter.isEmpty()) {
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
        entity.setGenderType(character.getGenderType().getName());
        entity.setRaceType(character.getRaceType().getName());
        entity.setJobType(character.getJobType().getName());
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
