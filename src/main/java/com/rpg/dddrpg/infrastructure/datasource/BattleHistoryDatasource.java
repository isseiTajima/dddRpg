package com.rpg.dddrpg.infrastructure.datasource;

import com.rpg.dddrpg.domain.mapper.battlehistory.BattleDetailHistoryMapperEntity;
import com.rpg.dddrpg.domain.mapper.battlehistory.BattleDetailHistoryMapperRepository;
import com.rpg.dddrpg.domain.mapper.battlehistory.BattleHistoryMapperEntity;
import com.rpg.dddrpg.domain.mapper.battlehistory.BattleHistoryMapperRepository;
import com.rpg.dddrpg.domain.model.battle.BattleDetailHistory;
import com.rpg.dddrpg.domain.model.battle.BattleDetailsHistory;
import com.rpg.dddrpg.domain.model.battle.BattleHistory;
import com.rpg.dddrpg.domain.repository.BattleHistoryRepository;
import com.rpg.dddrpg.domain.type.ActionType;
import com.rpg.dddrpg.domain.value.Hp;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class BattleHistoryDatasource implements BattleHistoryRepository {

    private BattleHistoryMapperRepository battleHistoryMapperRepository;
    private BattleDetailHistoryMapperRepository battleDetailHistoryMapperRepository;

    @Override
    public BattleHistory findOneById(UUID id) {

        // キャラクター情報を取得する
        BattleHistoryMapperEntity entity = battleHistoryMapperRepository.findById(id.toString());

        var builder = BattleHistory.builder();
        builder.id(UUID.fromString(entity.getId()));
        builder.battleDetailsHistory(createBattleDetailFrom(getBattleDetailEntity(id)));

        // 存在しない場合は空を返す
        if (entity == null) {
            return BattleHistory.builder().build();
        }

        return builder.build();
    }


    /**
     * Entity からモデルを作成
     *
     * @param battleDetailEntities 戦闘履歴EntityList
     * @return BattleDetailsHistory　モデル
     */
    BattleDetailsHistory createBattleDetailFrom(List<BattleDetailHistoryMapperEntity> battleDetailEntities) {

        List<BattleDetailHistory> modelList = new ArrayList();
        battleDetailEntities.forEach(e -> {
            var builder = BattleDetailHistory.builder();
            builder.id(UUID.fromString(e.getId()));
            builder.characterId(e.getCharacterId());
            builder.actionType(ActionType.findByName(e.getActionType()));
            builder.hp(Hp.of(e.getHp()));
            builder.enemyCharacterId(e.getEnemyCharacterId());
            builder.enemyActionType(ActionType.findByName(e.getEnemyActionType()));
            builder.enemyHp(Hp.of(e.getHp()));
            modelList.add(builder.build());
        });

        return BattleDetailsHistory.of(modelList);
    }

    List<BattleDetailHistoryMapperEntity> getBattleDetailEntity(UUID id) {
        return battleDetailHistoryMapperRepository.findById(id);
    }

    @Override
    public void save(BattleHistory battleHistory) {

        // 存在チェック
        BattleHistory duplicateHistory = findOneById(battleHistory.getId());

        // 存在しない場合はインサート
        if (duplicateHistory == null) {
            // キャラクターテーブルにインサート
            insertBattleHistory(battleHistory);
            // キャラクターステータステーブルにインサート
            insertBattleDetailHistory(battleHistory.getBattleDetailsHistory());
        }
    }

    /**
     * 戦闘履歴テーブルにインサート
     *
     * @param battleHistory 　登録する戦闘履歴
     */
    void insertBattleHistory(BattleHistory battleHistory) {
        // 戦闘履歴テーブルにインサート
        battleHistoryMapperRepository.insert(createMapperEntityFrom(battleHistory));
    }

    /**
     * 戦闘明細履歴テーブルにインサート
     *
     * @param detailsHistory 　戦闘履歴s
     */
    void insertBattleDetailHistory(BattleDetailsHistory detailsHistory) {
        // 戦闘明細履歴テーブルにインサート
        battleDetailHistoryMapperRepository.insertBulk(createDetailMapperEntitiesFrom(detailsHistory));
    }

    /**
     * MapperEntityを作成する
     *
     * @param bh 戦闘履歴
     * @return MapperEntity
     */
    BattleHistoryMapperEntity createMapperEntityFrom(BattleHistory bh) {
        BattleHistoryMapperEntity entity = new BattleHistoryMapperEntity();
        entity.setId(bh.getId().toString());
        return entity;
    }


    /**
     * MapperEntityを作成する
     *
     * @param detailsHistory 戦闘明細履歴s
     * @return MapperEntities
     */
    List<BattleDetailHistoryMapperEntity> createDetailMapperEntitiesFrom(BattleDetailsHistory detailsHistory) {

        List<BattleDetailHistoryMapperEntity> entityList = new ArrayList();

        detailsHistory.getList().forEach(detail -> {
            var entity = new BattleDetailHistoryMapperEntity();
            entity.setId(detail.getId().toString());
            entity.setBattleHistoryId(detail.getBattleHistoryId().toString());
            // お試しUUID設定
            entity.setCharacterId(detail.getCharacterId());
            entity.setActionType(detail.getActionType().getName());
            entity.setHp(detail.getHp().getValue());
            entity.setEnemyCharacterId(detail.getEnemyCharacterId());
            entity.setEnemyActionType(detail.getEnemyActionType().getName());
            entity.setEnemyHp(detail.getEnemyHp().getValue());
            entityList.add(entity);
        });
        return entityList;
    }

}
