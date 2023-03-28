package com.rpg.dddrpg.application.service;

import com.rpg.dddrpg.domain.model.enemy.Enemy;
import com.rpg.dddrpg.domain.model.enemy.EnemyStatus;
import com.rpg.dddrpg.domain.repository.EnemyRepository;
import com.rpg.dddrpg.domain.value.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * 敵登録更新に関するサービス
 */
@Service
@Transactional
public class EnemyRegisterService {

    @Autowired
    private final EnemyRepository enemyRepository;

    EnemyRegisterService(EnemyRepository enemyRepository) {
        this.enemyRepository = enemyRepository;
    }

    /**
     * 敵作成(登録)
     *
     * @param name 敵名
     * @return 敵
     */
    public void execute(Name name) {

        // キャラクターの生成
        UUID enemyId = UUID.randomUUID();
        Enemy enemy = Enemy.builder()
                .id(enemyId)
                .name(name)
                .status(createStatus(enemyId))
                .build();

        // キャラクターの保存
        enemyRepository.save(enemy);
    }

    EnemyStatus createStatus(UUID enemyId) {
        return EnemyStatus.builder()
                .id(UUID.randomUUID())
                .enemyId(enemyId)
                .level(Level.initial())
                .hp(Hp.randomInitial())
                .attack(Attack.randomInitial())
                .defence(Defence.randomInitial())
                .speed(Speed.randomInitial())
                .build();
    }

}
