package com.rpg.dddrpg.infrastructure.datasource;

import com.rpg.dddrpg.domain.exception.BusinessException;
import com.rpg.dddrpg.domain.mapper.enemy.EnemyMapperEntity;
import com.rpg.dddrpg.domain.mapper.enemy.EnemyMapperRepository;
import com.rpg.dddrpg.domain.mapper.enemystatus.EnemyStatusMapperEntity;
import com.rpg.dddrpg.domain.mapper.enemystatus.EnemyStatusMapperRepository;
import com.rpg.dddrpg.domain.model.enemy.Enemy;
import com.rpg.dddrpg.domain.model.enemy.EnemyStatus;
import com.rpg.dddrpg.domain.repository.EnemyRepository;
import com.rpg.dddrpg.domain.value.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EnemyDatasource implements EnemyRepository {

    private final EnemyMapperRepository enemyMapperRepository;
    private final EnemyStatusMapperRepository enemyStatusMapperRepository;

    EnemyDatasource(EnemyMapperRepository enemyMapperRepository,
                    EnemyStatusMapperRepository enemyStatusMapperRepository) {
        this.enemyMapperRepository = enemyMapperRepository;
        this.enemyStatusMapperRepository = enemyStatusMapperRepository;
    }

    @Override
    public Enemy findOneById(UUID id) {

        // キャラクター情報を取得する
        EnemyMapperEntity entity = enemyMapperRepository.findById(id.toString());

        var builder = Enemy.builder();
        // 存在しない場合は空を返す
        if (entity == null) {
            return builder.build();
        }

        // Entityからキャラクターを作成する
        builder.id(UUID.fromString(entity.getId()));
        builder.name(Name.of(entity.getName()));
        // ステータスを取得して設定
        builder.status(createStatus(id));

        return builder.build();
    }

    /**
     * 敵IDからステータスを取得して生成する
     *
     * @param id 敵ID
     * @return　ステータス
     */
    EnemyStatus createStatus(UUID id) {

        // キャラクタIDからステータスEntityを取得
        var entity = enemyStatusMapperRepository.findByEnemyId(id.toString());

        var builder = EnemyStatus.builder();
        builder.id(UUID.fromString(entity.getId()));
        builder.level(Level.of(entity.getLevel()));
        builder.hp(Hp.of(entity.getHp()));
        builder.attack(Attack.of(entity.getAttack()));
        builder.defence(Defence.of(entity.getDefence()));
        builder.speed(Speed.of(entity.getSpeed()));
        return builder.build();
    }

    @Override
    public void save(Enemy Enemy) {
        // 存在チェック
        Enemy duplicateEnemy = findOneById(Enemy.getId());

        // 存在しない場合はインサート
        if (duplicateEnemy.isEmpty()) {
            // キャラクターテーブルにインサート
            insertEnemy(Enemy);
            // キャラクターステータステーブルにインサート
            insertEnemyStatus(Enemy);
            return;
        }
        throw new BusinessException("既に存在します。");
    }

    /**
     * 敵テーブルにインサート
     *
     * @param Enemy 　登録する敵
     */
    void insertEnemy(Enemy Enemy) {
        // 敵テーブルにインサート
        enemyMapperRepository.insert(createMapperEntityFrom(Enemy));
    }

    /**
     * 敵ステータステーブルにインサート
     *
     * @param Enemy 　登録する敵
     */
    void insertEnemyStatus(Enemy Enemy) {
        // 敵ステータステーブルにインサート
        enemyStatusMapperRepository.insert(createStatusMapperEntityFrom(Enemy.getId(),
                Enemy.getStatus()));
    }

    /**
     * MapperEntityを作成する
     *
     * @param Enemy 敵
     * @return MapperEntity
     */
    EnemyMapperEntity createMapperEntityFrom(Enemy Enemy) {
        EnemyMapperEntity entity = new EnemyMapperEntity();
        entity.setId(Enemy.getId().toString());
        entity.setName(Enemy.getName().getValue());
        return entity;
    }


    /**
     * MapperEntityを作成する
     *
     * @param EnemyId キャラクターId
     * @param status  キャラクターステータス
     * @return MapperEntity
     */
    EnemyStatusMapperEntity createStatusMapperEntityFrom(UUID EnemyId,
                                                         EnemyStatus status) {
        var entity = new EnemyStatusMapperEntity();
        entity.setId(status.getId().toString());
        entity.setEnemyId(EnemyId.toString());
        entity.setLevel(status.getLevel().getValue());
        entity.setHp(status.getHp().getValue());
        entity.setAttack(status.getAttack().getValue());
        entity.setDefence(status.getDefence().getValue());
        entity.setSpeed(status.getSpeed().getValue());
        return entity;
    }

}
